package com.chenghua.web;

public class HttpResponse<T> {

    private Integer statusCode;
    private String reasonPhrase;
    private T data;

    public HttpResponse(Integer statusCode, String reasonPhrase, T data) {
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
        this.data = data;
    }

    public HttpResponse(HttpStatusCode statusCode, T data) {
        this(statusCode.getCode(), statusCode.getReasonPhrase(), data);
    }

    public HttpResponse() {
        this(HttpStatusCode.SUCCESS.getCode(), HttpStatusCode.SUCCESS.getReasonPhrase(), null);
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
