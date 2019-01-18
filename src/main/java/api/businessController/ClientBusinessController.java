package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ClientDto;
import api.entities.Client;
import exceptions.NotFoundException;

public class ClientBusinessController {
    public String create(ClientDto clientdto) {
        Client client = new Client(clientdto.getName(), clientdto.getSurname());
        DaoFactory.getFactory().getClientsDao().save(client);
        return client.getId();

    }

    public void update(String id, ClientDto clientDto) {
        Client client = DaoFactory.getFactory().getClientsDao().read(id)
                .orElseThrow(() -> new NotFoundException("Client id: " + id));
        client.setName(client.getName()).setSurname(client.getSurname());
        DaoFactory.getFactory().getClientsDao().save(client);
    }

}
