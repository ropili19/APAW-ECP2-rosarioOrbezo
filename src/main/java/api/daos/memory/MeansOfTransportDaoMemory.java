package api.daos.memory;

import api.daos.MeansOfTransportDao;
import api.entities.MeansOfTransport;

public class MeansOfTransportDaoMemory extends GenericDaoMemory<MeansOfTransport> implements MeansOfTransportDao {
    @Override
    public String getId(MeansOfTransport meanOftransp) {
        return meanOftransp.getId();
    }

    @Override
    public void setId(MeansOfTransport meanOftransp, String id) {
        meanOftransp.setId(id);
    }

}


