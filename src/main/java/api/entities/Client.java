package api.entities;

public class Client {
    private String id;
    private String name;
    private String surname;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }


    public Client setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Client setId(String id) {
        this.id = id;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
