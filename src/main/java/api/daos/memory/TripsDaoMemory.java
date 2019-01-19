package api.daos.memory;
import api.daos.TripsDao;
import api.entities.Trip;

public class TripsDaoMemory extends GenericDaoMemory<Trip> implements TripsDao {
    @Override
    public String getId(Trip trip) {
        return trip.getId();
    }

    @Override
    public void setId(Trip trip, String id) {
        trip.setId(id);
    }
}
