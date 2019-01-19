package api.daos.memory;

import api.daos.ClientsDao;
import api.daos.DaoFactory;
import api.daos.MeansOfTransportDao;
import api.entities.MeansOfTransport;

public class DaoMemoryFactory extends DaoFactory {
    private ClientsDao clientsdao;
    private MeansOfTransportDao meansOtranspdao;

    @Override
    public ClientsDao getClientsDao() {
        if (clientsdao == null) {
            clientsdao = new ClientsDaoMemory();
        }
        return clientsdao;
    }
    @Override
    public MeansOfTransportDao getMeansOfTransportDao() {
        if (meansOtranspdao == null) {
            meansOtranspdao = new MeansOfTransportDaoMemory();
        }
        return meansOtranspdao;
    }

}
