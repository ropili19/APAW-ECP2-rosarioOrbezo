package api.dtos;

import api.entities.Client;
import api.entities.MeansOfTransport;
import api.entities.State;
import api.entities.Trip;

import java.util.ArrayList;
import java.util.List;
public class TripsDto {

    private String origin;
    private String destination;
    private List<Client> clients;
    private List<MeansOfTransport> meanlist;
    private State state;

    public TripsDto(String origin, String destination) {
        this(origin, destination, new ArrayList<Client>(), new ArrayList<MeansOfTransport>(), State.PREPAID);
    }
    public TripsDto(Trip trip) {
        this.origin=trip.getOrigin();
        this.destination =trip.getDestination();
        this.state = trip.getState();
        this.clients = trip.getClients();
        this.meanlist=trip.getMeansList();
    }
    public TripsDto(String origin, String destination, List<Client> clients, List<MeansOfTransport> meanlist, State state) {
        this.origin = origin;
        this.destination = destination;
        this.clients = clients;
        this.meanlist = meanlist;
        this.state = state;
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


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<MeansOfTransport> getMeanlist() {
        return meanlist;
    }

    public void setMeanlist(List<MeansOfTransport> meanlist) {
        this.meanlist = meanlist;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TripsDto{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", clients=" + clients +
                ", meanlist=" + meanlist +
                ", state=" + state +
                '}';
    }
}
