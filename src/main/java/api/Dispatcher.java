package api;
import exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
public class Dispatcher {

    public void submit(HttpRequest request, HttpResponse response) {
        String ERROR_MESSAGE = "{'error':'%S'}";
        try {
            switch (request.getMethod()) {
                case POST:
                    throw new RequestInvalidException("method error: " + request.getMethod());
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
        } catch (Exception exception) {  // Unexpected
            exception.printStackTrace();
            response.setBody(String.format(ERROR_MESSAGE, exception));
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}