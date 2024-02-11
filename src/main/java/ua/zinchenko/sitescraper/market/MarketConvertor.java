package ua.zinchenko.sitescraper.market;

import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.market.domain.Market;
import ua.zinchenko.sitescraper.market.domain.Runner;
import ua.zinchenko.sitescraper.market.dto.MarketDto;
import ua.zinchenko.sitescraper.market.dto.RunnerDto;

public class MarketConvertor {

    public Market marketDtoToEntity(MarketDto marketDto) {
        return new Market()
                .setId(marketDto.getId())
                .setName(marketDto.getName())
                .setRunners(marketDto.getRunners().stream().map(this::runnerDtoToEntity).toList());
    }

    public Runner runnerDtoToEntity(RunnerDto runnerDto) {
        return new Runner()
                .setId(runnerDto.getId())
                .setName(runnerDto.getName())
                .setPrice(runnerDto.getPrice());
    }
}
