package api.apiControllers;

import api.businessController.ClientBusinessController;
import api.businessController.MeansTransportBusinessController;
import api.dtos.ClientDto;
import api.dtos.MeansOfTransportDto;
import exceptions.ArgumentNotValidException;

public class MeansTransportApiController {
    public static final String MEANSOFTRANSPORT = "/meanstransports";

    private MeansTransportBusinessController mOfTransportBusinessController = new MeansTransportBusinessController();

    public String create(MeansOfTransportDto mofTransportDto) {
        this.validate(mofTransportDto, "MeanOfTransportDto");
        this.validate(mofTransportDto.getPrice(), "MeanOfTransportDto price");
        return this.mOfTransportBusinessController.create(mofTransportDto);
    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + "is NULL");
        }
    }
}
