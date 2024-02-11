package ua.zinchenko.sitescraper.market;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import ua.zinchenko.sitescraper.LeonBetHttpClient;
import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.market.domain.Market;
import ua.zinchenko.sitescraper.market.dto.MarketDto;

import java.util.List;

public class MarketScraper {

    private final Configuration configuration;
    private final LeonBetHttpClient httpClient;
    private final MarketConvertor marketConvertor;

    public MarketScraper(Configuration configuration, LeonBetHttpClient httpClient,
                         MarketConvertor marketConvertor) {
        this.configuration = configuration;
        this.httpClient = httpClient;
        this.marketConvertor = marketConvertor;
    }

    public List<Market> scrapEventMarkets(Event event) {
        List<MarketDto> markets = JsonPath.using(configuration)
                .parse(getEventInfoJson(event.getId()))
                .read("$.markets[*]", new TypeRef<List<MarketDto>>() {
                });

        return markets.stream()
                .map(marketConvertor::marketDtoToEntity)
                .toList();
    }

    private String getEventInfoJson(String eventId) {
        return httpClient.sendGetRequest("https://leonbets.com/api-2/betline/event/all?ctag=en-US&eventId=%s&flags=reg,urlv2,mm2,rrc,nodup,smg,outv2"
                        .formatted(eventId))
                .body();
    }
}
