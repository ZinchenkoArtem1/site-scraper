package ua.zinchenko.sitescraper.market.dto;

public class RunnerDto {

    private String id;
    private String name;
    private String price;

    public String getId() {
        return id;
    }

    public RunnerDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RunnerDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public RunnerDto setPrice(String price) {
        this.price = price;
        return this;
    }
}
