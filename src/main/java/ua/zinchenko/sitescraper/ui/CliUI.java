package ua.zinchenko.sitescraper.ui;

import ua.zinchenko.sitescraper.event.entity.Event;
import ua.zinchenko.sitescraper.market.domain.Market;
import ua.zinchenko.sitescraper.market.domain.Runner;

import java.util.List;
import java.util.Objects;

public class CliUI {

    public void printMarketsToConsole(List<Event> events) {
        events.stream()
                .filter(Objects::nonNull)
                .forEach(
                        event -> {
                            printFirstHeader(event);
                            printSecondHeader(event);
                            printMarkets(event.getMarkets());
                        }
                );
    }

    private void printFirstHeader(Event event) {
        System.out.printf("%s, %s%n", event.getSportName(), event.getLeagueName());
    }

    private void printSecondHeader(Event event) {
        System.out.printf("    %s, %s, %s%n", event.getName(), event.getEventTime(), event.getId());
    }

    private void printMarkets(List<Market> markets) {
        markets.forEach(market -> {
                    System.out.printf("        %s%n", market.getName());
                    printRunners(market.getRunners());
                }
        );
    }

    private void printRunners(List<Runner> runners) {
        runners.forEach(runner -> System.out.printf("            %s, %s, %s%n", runner.getName(), runner.getPrice(), runner.getId()));
    }
}
