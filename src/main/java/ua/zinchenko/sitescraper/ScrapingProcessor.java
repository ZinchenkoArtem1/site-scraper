package ua.zinchenko.sitescraper;

import ua.zinchenko.sitescraper.event.EventScraper;
import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.league.LeagueScraper;
import ua.zinchenko.sitescraper.market.MarketScraper;
import ua.zinchenko.sitescraper.market.domain.Market;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class ScrapingProcessor {

    private final LeagueScraper leagueScraper;
    private final EventScraper eventScraper;
    private final MarketScraper marketScraper;
    private final ExecutorService executorService;

    public ScrapingProcessor(LeagueScraper leagueScraper, EventScraper eventScraper, MarketScraper marketScraper, ExecutorService executorService) {
        this.leagueScraper = leagueScraper;
        this.eventScraper = eventScraper;
        this.marketScraper = marketScraper;
        this.executorService = executorService;
    }

    public List<Event> scrapEvents() {
        List<CompletableFuture<Event>> futureEvents = new ArrayList<>();
        List<String> scrapedLeagueIds = leagueScraper.scrapTopLeagueIds();

        for (String scrapedLeagueId : scrapedLeagueIds) {
            futureEvents.add(CompletableFuture.supplyAsync(() -> eventScraper.scrapLeagueTopEvent(scrapedLeagueId), executorService)
                    .thenApply(event -> {
                        List<Market> markets = marketScraper.scrapEventMarkets(event);
                        event.setMarkets(markets);
                        return event;
                    })
                    .exceptionally(exc -> {
                        System.err.println(exc.getMessage());
                        return null;
                    }));
        }

        return futureEvents.stream().map(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new IllegalStateException(e);
                    }
                })
                .toList();
    }
}
