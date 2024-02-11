package ua.zinchenko.sitescraper.event;

import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.event.dto.EventDto;

import java.time.Instant;

public class EventConvertor {

    public Event eventDtoToEntity(EventDto eventDto, String sportName, String leagueName) {
        return new Event()
                .setId(eventDto.getId())
                .setName(eventDto.getName())
                .setEventTime(Instant.ofEpochMilli(eventDto.getKickoff()))
                .setSportName(sportName)
                .setLeagueName(leagueName);
    }
}
