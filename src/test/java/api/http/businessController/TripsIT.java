package api.http.businessController;

import api.apiControllers.TripsApiController;
import api.dtos.TripsDto;
import api.entities.State;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TripsIT {

    @Test
    void testCreateTrips() {
        this.createTrips();
    }

    private String createTrips() {
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).body(new TripsDto("madrid", "1")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateTripWithoutTripsDto() {
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateClientWithoutClientDtoName() {
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).body(new TripsDto(null, null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateState() {
        String id = this.createTrips();
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).path(TripsApiController.ID_ID)
                .expandPath(id).path(TripsApiController.STATE).body(State.RESERVED).patch();
        new Client().submit(request);
    }


    @Test
    void testSearchTripsByOriginIsNotEmpty() {
        this.createTrips();

        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).path(TripsApiController.SEARCH)
                .param("q", "origin:madrid").get();
        List<TripsDto> trips = (List<TripsDto>) new Client().submit(request).getBody();
        assertFalse(trips.isEmpty());
    }

    @Test
    void testSearchTripsByOriginIsEmpty() {
        this.createTrips();
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).path(TripsApiController.SEARCH)
                .param("q", "origin:paris").get();
        List<TripsDto> trips = (List<TripsDto>) new Client().submit(request).getBody();
        assertTrue(trips.isEmpty());
    }

    @Test
    void testSearchTripsByOriginWithoutParamQ() {
        this.createTrips();

        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).path(TripsApiController.SEARCH)
                .param("error", "origin:madrid").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testSearchTripsByOriginParamError() {
        this.createTrips();

        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).path(TripsApiController.SEARCH)
                .param("error", "error:madrid").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}
