package api.http.businessController;

import api.apiControllers.ClientsApiController;
import api.apiControllers.TripsApiController;
import api.dtos.ClientDto;
import api.dtos.TripsDto;
import api.entities.State;
import api.entities.Trip;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripsIT {

    @Test
    void testCreateTrips() {
        this.createTrips();
    }

    private String createTrips() {
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).body(new TripsDto("0", "1")).post();
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
        HttpRequest request = HttpRequest.builder(TripsApiController.TRIPS).body(new TripsDto(null,null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }




}
