package api.dtos;

public class ClientDto {

    private String name;
    private String surname;

    public ClientDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public ClientDto(String name) {
        this(name, null);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
