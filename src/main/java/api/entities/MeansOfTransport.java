package api.entities;

public class MeansOfTransport {
    private String id;
    private Integer price;
    private String description;

    public MeansOfTransport( Integer price, String description) {
        this.price = price;
        this.description = description;
    }

    public MeansOfTransport(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public MeansOfTransport setId(String id) {
        this.id = id; return this;
    }

    public Integer getPrice() {
        return price;
    }

    public MeansOfTransport setPrice(Integer price) {
        this.price = price; return this;
    }

    public String getDescription() {
        return description;
    }

    public MeansOfTransport setDescription(String description) {
        this.description = description; return this;
    }

    @Override
    public String toString() {
        return "MeansOfTransport{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
