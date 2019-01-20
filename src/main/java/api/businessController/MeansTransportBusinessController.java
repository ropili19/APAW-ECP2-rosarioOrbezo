package api.businessController;

import api.daos.DaoFactory;
import api.dtos.MeansOfTransportDto;
import api.entities.MeansOfTransport;

public class MeansTransportBusinessController {
    public String create(MeansOfTransportDto meansTranspDto) {
        MeansOfTransport meansOfTrans = new MeansOfTransport(meansTranspDto.getPrice(), meansTranspDto.getDescription());
        DaoFactory.getFactory().getMeansOfTransportDao().save(meansOfTrans);
        return meansOfTrans.getId();

    }
}
