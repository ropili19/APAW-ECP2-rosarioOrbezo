package api.daos.memory;

import api.daos.ClientsDao;
import api.daos.DaoFactory;

public class DaoMemoryFactory extends DaoFactory {
    private ClientsDao clientsdao;
    @Override
    public ClientsDao getClientsDao() {
        if(clientsdao == null){
            clientsdao = new ClientsDaoMemory();
        }
        return clientsdao;
    }

}
