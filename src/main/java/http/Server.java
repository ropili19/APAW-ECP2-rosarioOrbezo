package http;

import api.Dispatcher;
import http.HttpRequest;
import http.HttpResponse;

public class Server {
    private Dispatcher dispatcher = new Dispatcher();

    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        dispatcher.submit(request, response);
        return response;
    }

}
