package api.apiControllers;

import api.businessController.TripsBusinessController;
import api.dtos.TripsDto;
import exceptions.ArgumentNotValidException;

public class TripsApiController {
    public static final String TRIPS = "/trips";

    private TripsBusinessController tripsBusinessController = new TripsBusinessController();

    public String create(TripsDto tripsDto) {
        this.validate(tripsDto, "tripsDto");
        this.validate(tripsDto.getOrigin(), "TripsDto origin");
        this.validate(tripsDto.getDestination(), "TripsDto destination");
        return this.tripsBusinessController.create(tripsDto);

    }

    private void validate(Object property, String message) {
        if (property == null) {
            throw new ArgumentNotValidException(message + "is NULL");
        }
    }
}
