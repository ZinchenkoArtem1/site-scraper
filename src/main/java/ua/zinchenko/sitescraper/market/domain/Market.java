package ua.zinchenko.sitescraper.market.domain;

import ua.zinchenko.sitescraper.event.entity.Event;

import java.util.List;

public class Market {

    private String id;
    private String name;
    private List<Runner> runners;

    public String getId() {
        return id;
    }

    public Market setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Market setName(String name) {
        this.name = name;
        return this;
    }

    public List<Runner> getRunners() {
        return runners;
    }

    public Market setRunners(List<Runner> runners) {
        this.runners = runners;
        return this;
    }
}
