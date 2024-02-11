package ua.zinchenko.sitescraper.market.dto;

import java.util.List;

public class MarketDto {

    private String id;
    private String name;
    private List<RunnerDto> runners;

    public String getId() {
        return id;
    }

    public MarketDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MarketDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<RunnerDto> getRunners() {
        return runners;
    }

    public MarketDto setRunners(List<RunnerDto> runners) {
        this.runners = runners;
        return this;
    }
}
