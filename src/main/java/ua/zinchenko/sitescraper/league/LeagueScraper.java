package ua.zinchenko.sitescraper.league;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;
import ua.zinchenko.sitescraper.LeonBetHttpClient;

import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class LeagueScraper {

    private static final List<String> AVAILABLE_SPORTS = List.of("Football", "Tennis", "Ice Hockey", "Basketball");
    private static final Filter AVAILABLE_SPORTS_FILTER = filter(
            where("name").in(AVAILABLE_SPORTS)
    );
    private static final Filter LEAGUES_FILTER = filter(
            where("top").is(true)
    );
    private final Configuration configuration;
    private final LeonBetHttpClient httpClient;

    public LeagueScraper(Configuration configuration, LeonBetHttpClient httpClient) {
        this.configuration = configuration;
        this.httpClient = httpClient;
    }

    public List<String> scrapTopLeagueIds() {
        return JsonPath.using(configuration)
                .parse(getLeaguesJson())
                .read(JsonPath.compile(
                                "$[?].regions[*].leagues[?].id",
                                AVAILABLE_SPORTS_FILTER, LEAGUES_FILTER),
                        new TypeRef<List<String>>() {
                        }
                );
    }

    private String getLeaguesJson() {
        return httpClient.sendGetRequest("https://leonbets.com/api-2/betline/sports?ctag=en-US&flags=urlv2")
                .body();
    }
}
