package ua.zinchenko.sitescraper.event.entity;

import ua.zinchenko.sitescraper.market.domain.Market;

import java.time.Instant;
import java.util.List;

public class Event {

    private String id;
    private String name;
    private Instant eventTime;
    private String leagueName;
    private String sportName;
    private List<Market> markets;

    public String getId() {
        return id;
    }

    public Event setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getEventTime() {
        return eventTime;
    }

    public Event setEventTime(Instant eventTime) {
        this.eventTime = eventTime;
        return this;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Event setLeagueName(String leagueName) {
        this.leagueName = leagueName;
        return this;
    }

    public String getSportName() {
        return sportName;
    }

    public Event setSportName(String sportName) {
        this.sportName = sportName;
        return this;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public Event setMarkets(List<Market> markets) {
        this.markets = markets;
        return this;
    }
}
