package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ClientDto;
import api.entities.Client;

public class ClientBusinessController {
    public String create(ClientDto clientdto) {
        Client client = new Client(clientdto.getName(), clientdto.getSurname());
        DaoFactory.getFactory().getClientsDao().save(client);
        return client.getId();

    }

}
