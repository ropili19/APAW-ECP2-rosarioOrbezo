package api;

import api.apiControllers.ClientsApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ClientDto;
import exceptions.ArgumentNotValidException;
import exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {
    private ClientsApiController clientsApiController = new ClientsApiController();

    static {
        DaoFactory.setFactory(new DaoMemoryFactory());//singleton
    }

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    this.doPost(request, response);
                    break;
                case GET:
                    throw new RequestInvalidException("method error: " + request.getMethod());
                case PUT:
                    throw new RequestInvalidException("method error: " + request.getMethod());
                case PATCH:
                    throw new RequestInvalidException("method error: " + request.getMethod());
                case DELETE:
                    throw new RequestInvalidException("method error: " + request.getMethod());
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());

            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(clientsApiController.CLIENTS)) {
            response.setBody(this.clientsApiController.create((ClientDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }
}