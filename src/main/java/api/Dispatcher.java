package api;

import api.apiControllers.ClientsApiController;
import api.apiControllers.MeansTransportApiController;
import api.apiControllers.TripsApiController;
import api.daos.DaoFactory;
import api.daos.memory.DaoMemoryFactory;
import api.dtos.ClientDto;
import api.dtos.MeansOfTransportDto;
import api.dtos.TripsDto;
import api.entities.State;
import exceptions.ArgumentNotValidException;
import exceptions.NotFoundException;
import exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {
    private ClientsApiController clientsApiController = new ClientsApiController();
    private MeansTransportApiController meanssApiController = new MeansTransportApiController();
    private TripsApiController tripsApiController = new TripsApiController();

    public static final String ID_ID = "/{id}";

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
                    this.doGet(request, response);
                    break;
                case PUT:
                    this.doPut(request);
                    break;
                case PATCH:
                    this.doPatch(request);
                    break;
                case DELETE:
                    this.doDelete(request);
                    break;
                default: // Unexpected
                    throw new RequestInvalidException("method error: " + request.getMethod());

            }
        } catch (ArgumentNotValidException | RequestInvalidException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.BAD_REQUEST);
        } catch (NotFoundException exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception.getMessage()));
            response.setStatus(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void doPatch(HttpRequest request) {
        if (request.isEqualsPath(TripsApiController.TRIPS + TripsApiController.ID_ID + TripsApiController.STATE)) {
            this.tripsApiController.updateSate(request.getPath(1), (State) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(clientsApiController.CLIENTS)) {
            response.setBody(this.clientsApiController.create((ClientDto) request.getBody()));
        } else if (request.isEqualsPath(MeansTransportApiController.MEANSOFTRANSPORT)) {
            response.setBody(this.meanssApiController.create((MeansOfTransportDto) request.getBody()));
        } else if (request.isEqualsPath(tripsApiController.TRIPS)) {
            response.setBody(this.tripsApiController.create((TripsDto) request.getBody()));
        } else {
            throw new RequestInvalidException("method error: " + request.getMethod());
        }
    }

    private void doPut(HttpRequest request) {
        if (request.isEqualsPath(ClientsApiController.CLIENTS + ClientsApiController.ID_ID)) {
            this.clientsApiController.update(request.getPath(1), (ClientDto) request.getBody());
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doGet(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath(ClientsApiController.CLIENTS)) {
            response.setBody(this.clientsApiController.readAll());
        } else if (request.isEqualsPath(TripsApiController.TRIPS + TripsApiController.SEARCH)) {
            response.setBody(this.tripsApiController.find(request.getParams().get("q")));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }

    private void doDelete(HttpRequest request) {
        if (request.isEqualsPath(ClientsApiController.CLIENTS + ClientsApiController.ID_ID)) {
            this.clientsApiController.delete(request.getPath(1));
        } else {
            throw new RequestInvalidException("request error: " + request.getMethod() + ' ' + request.getPath());
        }
    }
}