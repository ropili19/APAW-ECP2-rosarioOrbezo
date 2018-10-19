package api.entities;

public class Client {
    private String id;
    private String name;
    private String firstsurname;

    public Client(String id, String name, String first_surname) {
        this.id = id;
        this.name = name;
        this.firstsurname = first_surname;
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
        return firstsurname;
    }

    public void setFirst_surname(String first_surname) {
        this.firstsurname = first_surname;
    }
}
