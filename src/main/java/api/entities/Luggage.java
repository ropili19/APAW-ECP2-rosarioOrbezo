package api.entities;

public class Luggage {
    private String id;
    private boolean ishand_lugagge;

    public Luggage(String id, boolean ishand_lugagge) {
        this.id = id;
        this.ishand_lugagge = ishand_lugagge;
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

    public boolean isIshand_lugagge() {
        return ishand_lugagge;
    }

    public void setIshand_lugagge(boolean ishand_lugagge) {
        this.ishand_lugagge = ishand_lugagge;
    }
}
