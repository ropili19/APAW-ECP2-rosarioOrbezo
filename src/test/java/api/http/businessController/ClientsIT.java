package api.http.businessController;

import api.apiControllers.ClientsApiController;
import api.dtos.ClientDto;
import http.Client;
import http.HttpException;
import http.HttpRequest;
import http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientsIT {

    @Test
    void testCreateClient() {
        this.createClient();
    }

    private String createClient() {
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).body(new ClientDto("rosario", "orbezo")).post();
        return (String) new Client().submit(request).getBody();
    }

    @Test
    void testCreateClientWithoutClientDto() {
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).body(null).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testCreateClientWithoutClientDtoName() {
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).body(new ClientDto(null)).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateUser() {
        String id = this.createClient();
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).path(ClientsApiController.ID_ID)
                .expandPath(id).body(new ClientDto("rosario")).put();
        new Client().submit(request);
    }

    @Test
    void testUpdateUserWithoutUserDto() {
        String id = this.createClient();
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).path(ClientsApiController.ID_ID)
                .expandPath(id).body(null).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void testUpdateUserNotFoundException() {
        HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).path(ClientsApiController.ID_ID)
                .expandPath("incorrecto").body(new ClientDto("rosario")).put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }
}
