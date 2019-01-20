package api.apiControllers;

import api.businessController.ClientBusinessController;
import api.dtos.ClientDto;
import exceptions.ArgumentNotValidException;

import java.util.List;

public class ClientsApiController {
    public static final String CLIENTS = "/clients";
    public static final String ID_ID = "/{id}";
    private ClientBusinessController clientsBusinessController = new ClientBusinessController();

    public String create(ClientDto clientDto) {
        this.validate(clientDto, "clientDto");
        this.validate(clientDto.getName(), "ClientDto Name");
        return this.clientsBusinessController.create(clientDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + "is NULL");
        }
    }

    public void update(String id, ClientDto clientDto) {
        this.validate(clientDto, "userDto");
        this.validate(clientDto.getName(), "ClientDto surname");
        this.clientsBusinessController.update(id, clientDto);
    }
    public List<ClientDto> readAll() {
        return this.clientsBusinessController.readAll();
    }

}
