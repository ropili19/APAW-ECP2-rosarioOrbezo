package api.daos.memory;

import api.daos.ClientsDao;
import api.entities.Client;

import java.util.HashMap;

public class ClientsDaoMemory extends GenericDaoMemory<Client> implements ClientsDao {
    @Override
    public String getId(Client client) {
        return client.getId();
    }

    @Override
    public void setId(Client client, String id) {
        client.setId(id);
    }


}
