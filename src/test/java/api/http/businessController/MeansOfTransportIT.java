package api.http.businessController;

import api.apiControllers.ClientsApiController;
import api.apiControllers.MeansTransportApiController;
import api.dtos.ClientDto;
import api.dtos.MeansOfTransportDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeansOfTransportIT {

    @Test
    void testCreateMeans() {
        this.createMeansTrans();
    }

    private String createMeansTrans() {
        HttpRequest request = HttpRequest.builder(MeansTransportApiController.MEANSOFTRANSPORT).body(new MeansOfTransportDto(1000, "TRAIN")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateClientWithoutMeansDto() {
        HttpRequest request = HttpRequest.builder(MeansTransportApiController.MEANSOFTRANSPORT).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateMeansOfTransportWithoutPrice() {
        HttpRequest request = HttpRequest.builder(MeansTransportApiController.MEANSOFTRANSPORT).body(new MeansOfTransportDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }


}
