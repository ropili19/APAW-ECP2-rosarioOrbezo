package api.businessController;

import api.daos.DaoFactory;
import api.dtos.ClientDto;
import api.dtos.TripsDto;
import api.entities.Client;
import api.entities.Trip;
import exceptions.NotFoundException;

public class TripsBusinessController {
    public String create(TripsDto tripsdto) {
        Trip trip = new Trip(tripsdto.getOrigin(), tripsdto.getDestination());
       // Trip trip = new Trip(tripsdto.getOrigin(), tripsdto.getDestination(),tripsdto.getClients(),tripsdto.getMeanlist(),tripsdto.getState());
        DaoFactory.getFactory().getTripsDao().save(trip);
        return trip.getId();

    }



}
