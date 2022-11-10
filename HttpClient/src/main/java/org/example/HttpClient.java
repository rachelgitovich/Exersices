package org.example;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class HttpClient {
    CloseableHttpClient httpClient;
    Gson gson;
    private static HttpClient instance;

    public static synchronized HttpClient getInstance() {
        if (instance == null) {
            instance = new HttpClient();
        }
        return instance;
    }

    private HttpClient() {
        httpClient = HttpClients.createDefault();
        gson = new Gson();

    }

    public <T> Response request(Method method, String url, Map<String, Object> headers, T body) {
        HttpUriRequestBase request = null;
        switch (method) {
            case GET:
                request = new HttpGet(url);
                break;
            case POST:
                request = new HttpPost(url);
                break;
            case PUT:
                request = new HttpPut(url);
                break;
            case PATCH:
                request = new HttpPatch(url);
                break;
            case DELETE:
                request = new HttpDelete(url);
                break;
            default:
                throw new IllegalArgumentException("Http method not supported");
        }
        HttpUriRequestBase finalRequest = request;
        headers.forEach((key, value) -> finalRequest.setHeader(key, value));
        request.setHeaders(finalRequest.getHeaders());
        CloseableHttpResponse realResponse = null;
        Response customResponse = null;
        request.setEntity(new StringEntity(gson.toJson(body)));
        try {
            realResponse = httpClient.execute(request);
            customResponse = new Response(realResponse.getCode(), realResponse.getReasonPhrase(), Arrays.asList(realResponse.getHeaders()), IOUtils.toString(realResponse.getEntity().getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return customResponse;
    }
}
