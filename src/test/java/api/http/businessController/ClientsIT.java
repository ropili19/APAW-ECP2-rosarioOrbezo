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
            HttpRequest request = HttpRequest.builder(ClientsApiController.CLIENTS).body(new ClientDto("rosario","orbezo")).post();
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
}
