package api.apiControllers;

import api.businessController.TripsBusinessController;
import api.dtos.TripsDto;
import api.entities.State;
import exceptions.ArgumentNotValidException;

import java.util.List;

public class TripsApiController {
    public static final String TRIPS = "/trips";
    public static final String ID_ID = "/{id}";
    public static final String STATE = "/state";
    public static final String SEARCH = "/search";
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

    public void updateSate(String themeId, State state) {
        this.validate(state, "state");
        this.tripsBusinessController.updateCategory(themeId, state);
    }

    public List<TripsDto> find(String query) {
        this.validate(query, "query param q");
        if (!"origin".equals(query.split(":")[0])) {
            throw new ArgumentNotValidException("query param q is incorrect, missing 'origin='");
        }
        return this.tripsBusinessController.findByOrigin(query.split(":")[1]);
    }
}
