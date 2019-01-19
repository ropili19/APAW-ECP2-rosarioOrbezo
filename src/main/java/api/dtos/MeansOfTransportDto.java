package api.dtos;

public class MeansOfTransportDto {

    private Integer price;
    private String description;

    public MeansOfTransportDto(Integer price, String description) {
        this.price = price;
        this.description = description;
    }

    public MeansOfTransportDto(Integer price) {
        this(price, null);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MeansOfTransportDto{" +
                "price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
