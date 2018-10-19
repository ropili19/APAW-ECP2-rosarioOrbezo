package api.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Trip {
    private String id;
    private String origin;
    private String destination;
    private LocalDateTime trip_date;
    private List<Client> clients;
    private List<Means_of_transport> meansList;
    private State state;

    public Trip(String id, String origin, String destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    public Trip(String id, String origin, String destination, LocalDateTime trip_date, List<Client> clients, List<Means_of_transport> meansList, State state) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.trip_date = trip_date;
        this.clients = clients;
        this.meansList = meansList;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(LocalDateTime trip_date) {
        this.trip_date = trip_date;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Means_of_transport> getMeansList() {
        return meansList;
    }

    public void setMeansList(List<Means_of_transport> meansList) {
        this.meansList = meansList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
