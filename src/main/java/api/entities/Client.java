package api.entities;

public class Client {
    private String id;
    private String name;
    private String first_surname;

    public Client(String id, String name, String first_surname) {
        this.id = id;
        this.name = name;
        this.first_surname = first_surname;
    }

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }
}
