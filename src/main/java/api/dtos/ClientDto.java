package api.dtos;

public class ClientDto {

    private String name;
    private String firstsurname;

    public ClientDto(String name, String firstsurname) {
        this.name = name;
        this.firstsurname = firstsurname;
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

    public String getFirstsurname() {
        return firstsurname;
    }

    public void setFirstsurname(String firstsurname) {
        this.firstsurname = firstsurname;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "name='" + name + '\'' +
                ", firstsurname='" + firstsurname + '\'' +
                '}';
    }
}
