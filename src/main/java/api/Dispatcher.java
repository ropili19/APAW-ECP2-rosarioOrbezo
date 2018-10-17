package api;


import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;

public class Dispatcher {

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                case GET:

                case PUT:

                case PATCH:

                case DELETE:

                default:
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}