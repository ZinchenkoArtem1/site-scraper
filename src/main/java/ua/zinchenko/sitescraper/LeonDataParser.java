package ua.zinchenko.sitescraper;

import ua.zinchenko.sitescraper.config.ExecutorConfig;
import ua.zinchenko.sitescraper.config.JsonPathConfig;
import ua.zinchenko.sitescraper.event.EventConvertor;
import ua.zinchenko.sitescraper.event.EventScraper;
import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.league.LeagueScraper;
import ua.zinchenko.sitescraper.market.MarketConvertor;
import ua.zinchenko.sitescraper.market.MarketScraper;
import ua.zinchenko.sitescraper.ui.CliUI;

import java.util.List;

public class LeonDataParser {

    public static void main(String[] args) {
        LeonBetHttpClient httpClient = new LeonBetHttpClient();

        LeagueScraper leagueScraper = new LeagueScraper(JsonPathConfig.getConfiguration(), httpClient);
        EventScraper eventScraper = new EventScraper(JsonPathConfig.getConfiguration(), httpClient, new EventConvertor());
        MarketScraper marketScraper = new MarketScraper(JsonPathConfig.getConfiguration(), httpClient, new MarketConvertor());

        CliUI cliUI = new CliUI();

        try {
            ScrapingProcessor scrapingProcessor = new ScrapingProcessor(leagueScraper, eventScraper, marketScraper, ExecutorConfig.getExecutorService());
            List<Event> events = scrapingProcessor.scrapEvents();
            cliUI.printMarketsToConsole(events);
        } finally {
            ExecutorConfig.getExecutorService().shutdownNow();
        }
    }

}
