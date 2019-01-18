package api.entities;

public class MeansOfTransport {
    private String id;
    private int price;
    private String description;

    public MeansOfTransport(String id, int price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public MeansOfTransport(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
