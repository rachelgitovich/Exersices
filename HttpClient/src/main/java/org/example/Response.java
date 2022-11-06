package org.example;

import java.util.List;

public class Response {
    private int statusCode;
    private String statusPhrase;
    private List<?> headers;
    private String body;

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<?> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public Response(int statusCode, String statusPhrase, List<?> headers, String body) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String toString() {
        return "{" +
                "statusCode: " + statusCode + System.lineSeparator() +
                "statusPhrase: " + statusPhrase + System.lineSeparator() +
                "headers: " + headers + System.lineSeparator() +
                "body: " + body + System.lineSeparator() +
                '}';
    }
}
