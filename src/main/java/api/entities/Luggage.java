package api.entities;

public class Luggage {
    private String id;
    private boolean ishandLugagge;

    public Luggage(String id, boolean ishandlugagge) {
        this.id = id;
        this.ishandLugagge = ishandlugagge;
    }

    public Luggage(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIshandLugagge() {
        return ishandLugagge;
    }

    public void setIshandLugagge(boolean ishandLugagge) {
        this.ishandLugagge = ishandLugagge;
    }

}
