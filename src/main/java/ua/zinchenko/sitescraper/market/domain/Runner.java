package ua.zinchenko.sitescraper.market.domain;

public class Runner {

    private String id;
    private String name;
    private String price;

    public String getId() {
        return id;
    }

    public Runner setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Runner setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Runner setPrice(String price) {
        this.price = price;
        return this;
    }
}
