package com.chenghua.web;

public abstract class ControllerBase {

    protected HttpResponse success(Object data){
        return new HttpResponse(HttpStatusCode.SUCCESS, data);
    }

    protected HttpResponse success(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.SUCCESS.getCode(), reasonPhrase, data);
    }

}
