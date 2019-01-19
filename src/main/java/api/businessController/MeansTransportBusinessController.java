package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ClientDto;
import api.dtos.MeansOfTransportDto;
import api.entities.Client;
import api.entities.MeansOfTransport;
import exceptions.NotFoundException;

public class MeansTransportBusinessController {
    public String create(MeansOfTransportDto meansTranspDto) {
        MeansOfTransport meansOfTrans = new MeansOfTransport(meansTranspDto.getPrice(), meansTranspDto.getDescription());
        DaoFactory.getFactory().getMeansOfTransportDao().save(meansOfTrans);
        return meansOfTrans.getId();

    }



}
