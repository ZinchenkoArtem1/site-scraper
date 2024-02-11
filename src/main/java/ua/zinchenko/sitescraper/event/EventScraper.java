package ua.zinchenko.sitescraper.event;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import ua.zinchenko.sitescraper.LeonBetAsyncHttpClient;
import ua.zinchenko.sitescraper.event.dto.EventDto;
import ua.zinchenko.sitescraper.event.entity.Event;

import java.net.http.HttpResponse;

public class EventScraper {

    private final Configuration configuration;
    private final LeonBetAsyncHttpClient httpClient;
    private final EventConvertor eventConvertor;

    public EventScraper(Configuration configuration, LeonBetAsyncHttpClient httpClient,
                        EventConvertor eventConvertor) {
        this.configuration = configuration;
        this.httpClient = httpClient;
        this.eventConvertor = eventConvertor;
    }

    public Event scrapLeagueTopEvent(String leagueId) {
        DocumentContext documentContext = JsonPath.using(configuration)
                .parse(getLeagueEvents(leagueId).body());
        EventDto eventDto = documentContext.read(JsonPath.compile(
                        "$.data[0]"),
                EventDto.class
        );
        String leagueName = documentContext.read(JsonPath.compile(
                        "$.data[0].league.name"),
                String.class);
        String sportName = documentContext.read(JsonPath.compile(
                        "$.data[0].league.sport.name"),
                String.class);

        return eventConvertor.eventDtoToEntity(eventDto, sportName, leagueName);
    }

    private HttpResponse<String> getLeagueEvents(String leagueId) {
        return httpClient.sendGetRequest(
                "https://leonbets.com/api-2/betline/changes/all?ctag=en-US&vtag=9c2cd386-31e1-4ce9-a140-28e9b63a9300&league_id=%s&hideClosed=true&flags=reg,urlv2,mm2,rrc,nodup"
                        .formatted(leagueId)
        );
    }
}
