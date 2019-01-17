package api.entities;

public class Client {
    private String id;
    private String name;
    private String firstsurname;

    public Client(String name, String firstsurname) {
        this.name = name;
        this.firstsurname = firstsurname;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstsurname() {
        return firstsurname;
    }

    public Client setFirstsurname(String firstsurname) {
        this.firstsurname = firstsurname;
        return this;
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firstsurname='" + firstsurname + '\'' +
                '}';
    }
}
