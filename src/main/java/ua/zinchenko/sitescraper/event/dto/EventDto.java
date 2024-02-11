package ua.zinchenko.sitescraper.event.dto;

public class EventDto {

    private String id;
    private String name;
    private Long kickoff;

    public String getId() {
        return id;
    }

    public EventDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EventDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getKickoff() {
        return kickoff;
    }

    public EventDto setKickoff(Long kickoff) {
        this.kickoff = kickoff;
        return this;
    }
}
