package api.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Trip {
    private String id;
    private String origin;
    private String destination;
    private LocalDateTime tripDate;
    private List<Client> clients;
    private List<MeansOfTransport> meansList;
    private State state;

    public Trip(String id, String origin, String destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    public Trip(String id, String origin, String destination, LocalDateTime tripdate, List<Client> clients, List<MeansOfTransport> meansList, State state) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.tripDate = tripdate;
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

    public void setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<MeansOfTransport> getMeansList() {
        return meansList;
    }

    public void setMeansList(List<MeansOfTransport> meansList) {
        this.meansList = meansList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
