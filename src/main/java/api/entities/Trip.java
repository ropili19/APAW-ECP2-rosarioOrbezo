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

    public Trip(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Trip( String origin, String destination, List<Client> clients, List<MeansOfTransport> meansList, State state) {

        this.origin = origin;
        this.destination = destination;
        this.tripDate = LocalDateTime.now();
        this.clients = clients;
        this.meansList = meansList;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public Trip setId(String id) {
        this.id = id;  return this;
    }

    public String getOrigin() {
        return origin;
    }

    public Trip setOrigin(String origin) {
        this.origin = origin;    return this;
    }

    public String getDestination() {
        return destination;
    }

    public Trip setDestination(String destination) {
        this.destination = destination;return this;
    }

    public Trip setTripDate(LocalDateTime tripDate) {
        this.tripDate = tripDate; return this;
    }

    public LocalDateTime getTripDate() {
        return tripDate;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Trip setClients(List<Client> clients) {
        this.clients = clients; return this;
    }

    public List<MeansOfTransport> getMeansList() {
        return meansList;
    }

    public Trip setMeansList(List<MeansOfTransport> meansList) {
        this.meansList = meansList;return this;
    }

    public State getState() {
        return state;
    }

    public Trip setState(State state) {
        this.state = state; return this;
    }
}
