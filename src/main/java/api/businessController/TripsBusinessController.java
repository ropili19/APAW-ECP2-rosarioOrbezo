package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TripsDto;
import api.entities.Trip;

public class TripsBusinessController {
    public String create(TripsDto tripsdto) {
        Trip trip = new Trip(tripsdto.getOrigin(), tripsdto.getDestination());
        DaoFactory.getFactory().getTripsDao().save(trip);
        return trip.getId();

    }
}
