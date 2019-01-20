package api.businessController;

import api.daos.DaoFactory;
import api.dtos.TripsDto;
import api.entities.State;
import api.entities.Trip;
import exceptions.NotFoundException;

public class TripsBusinessController {
    public String create(TripsDto tripsdto) {
        Trip trip = new Trip(tripsdto.getOrigin(), tripsdto.getDestination());
        DaoFactory.getFactory().getTripsDao().save(trip);
        return trip.getId();

    }
    public void delete(String id) {
        DaoFactory.getFactory().getClientsDao().deleteById(id);
    }
    public void updateCategory(String tripId, State state) {
        Trip trip = DaoFactory.getFactory().getTripsDao().read(tripId)
                .orElseThrow(() -> new NotFoundException("Trip (" + tripId + ")"));
        trip.setState(state);
        DaoFactory.getFactory().getTripsDao().save(trip);
    }

}
