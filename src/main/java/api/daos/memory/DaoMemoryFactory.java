package api.daos.memory;

import api.daos.ClientsDao;
import api.daos.DaoFactory;
import api.daos.MeansOfTransportDao;
import api.daos.TripsDao;

public class DaoMemoryFactory extends DaoFactory {
    private ClientsDao clientsdao;
    private MeansOfTransportDao meansOtranspdao;
    private TripsDao tripsdao;

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
    @Override
    public TripsDao getTripsDao() {
        if (tripsdao == null) {
            tripsdao = new TripsDaoMemory();
        }
        return tripsdao;
    }

}
