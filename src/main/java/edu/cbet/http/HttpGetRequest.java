package edu.cbet.http;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpGetRequest {
    private final String host;
    private final String path;
    private final Map<String, String> queryStrings;
    private final Map<String, String> requestHeaders;

    public HttpGetRequest(String host, String path) {
        this(host, path, new LinkedHashMap<>(), new LinkedHashMap<>());
    }

    public HttpGetRequest(String host, String path, HashMap<String, String> requestHeaders, HashMap<String, String> queryStrings) {
        this.host = host;
        this.path = path;
        this.requestHeaders = requestHeaders;
        this.queryStrings = queryStrings;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public void addQueryString(String name, String value) {
        this.queryStrings.put(name, value);
    }

    public void addRequestHeader(String name, String value) {
        this.requestHeaders.put(name, value);
    }

    public String getPathAndQueries() {
        StringBuilder getPathBuilder = new StringBuilder(host);
        getPathBuilder.append('?');

        for(Map.Entry<String, String> entry: queryStrings.entrySet()) {
            getPathBuilder.append(entry.getKey()).append('=').append(entry.getValue());
            getPathBuilder.append('&');
        }

        getPathBuilder.deleteCharAt(getPathBuilder.length()-1); //Delete extraneous ampersand

        return getPathBuilder.toString();
    }

    public String getCompiledRequest() {
        StringBuilder requestBuilder = new StringBuilder();

        requestBuilder.append("GET ").append(path);

        if(queryStrings.size() != 0) {
            requestBuilder.append('?');

            for (Map.Entry<String, String> entry : queryStrings.entrySet()) {
                requestBuilder.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
            }

            requestBuilder.deleteCharAt(requestBuilder.length()-1); //Delete extraneous ampersand
        }

        requestBuilder.append(" HTTP/1.0\r\n\r\n");

        for(Map.Entry<String, String> header: requestHeaders.entrySet()) {
            requestBuilder.append(header.getKey()).append(": ").append(header.getValue()).append("\r\n");
        }

        //requestBuilder.append('\n');

        return requestBuilder.toString();
    }
}
