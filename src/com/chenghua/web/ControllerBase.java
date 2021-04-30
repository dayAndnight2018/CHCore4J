package com.chenghua.web;

public abstract class ControllerBase {

    protected HttpResponse success(Object data){
        return new HttpResponse(HttpStatusCode.SUCCESS, data);
    }

    protected HttpResponse success(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.SUCCESS.getCode(), reasonPhrase, data);
    }

    protected HttpResponse badRequest(Object data){
        return new HttpResponse(HttpStatusCode.BAD_REQUEST, data);
    }

    protected HttpResponse badRequest(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.BAD_REQUEST.getCode(), reasonPhrase, data);
    }

    protected HttpResponse noContent(Object data){
        return new HttpResponse(HttpStatusCode.NO_CONTENT, data);
    }

    protected HttpResponse noContent(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.NO_CONTENT.getCode(), reasonPhrase, data);
    }

    protected HttpResponse temporarilyRedirect(Object data){
        return new HttpResponse(HttpStatusCode.MOVE_TEMPORARILY, data);
    }

    protected HttpResponse temporarilyRedirect(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.MOVE_TEMPORARILY.getCode(), reasonPhrase, data);
    }

    protected HttpResponse permanentlyRedirect(Object data){
        return new HttpResponse(HttpStatusCode.MOVE_PERMANENTLY, data);
    }

    protected HttpResponse permanentlyRedirect(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.MOVE_PERMANENTLY.getCode(), reasonPhrase, data);
    }

    protected HttpResponse notModified(Object data){
        return new HttpResponse(HttpStatusCode.NOT_MODIFIED, data);
    }

    protected HttpResponse notModified(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.NOT_MODIFIED.getCode(), reasonPhrase, data);
    }

    protected HttpResponse unAuthorized(Object data){
        return new HttpResponse(HttpStatusCode.UNAUTHORIZED, data);
    }

    protected HttpResponse unAuthorized(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.UNAUTHORIZED.getCode(), reasonPhrase, data);
    }

    protected HttpResponse forbidden(Object data){
        return new HttpResponse(HttpStatusCode.FORBIDDEN, data);
    }

    protected HttpResponse forbidden(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.FORBIDDEN.getCode(), reasonPhrase, data);
    }

    protected HttpResponse notFound(Object data){
        return new HttpResponse(HttpStatusCode.NOT_FOUND, data);
    }

    protected HttpResponse notFound(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.NOT_FOUND.getCode(), reasonPhrase, data);
    }

    protected HttpResponse methodNotFound(Object data){
        return new HttpResponse(HttpStatusCode.METHOD_NOT_FOUND, data);
    }

    protected HttpResponse methodNotFound(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.METHOD_NOT_FOUND.getCode(), reasonPhrase, data);
    }

    protected HttpResponse serverError(Object data){
        return new HttpResponse(HttpStatusCode.INTERNAL_SERVER_ERROR, data);
    }

    protected HttpResponse serverError(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.INTERNAL_SERVER_ERROR.getCode(), reasonPhrase, data);
    }

    protected HttpResponse serverUnavailable(Object data){
        return new HttpResponse(HttpStatusCode.SERVER_UNAVAILABLE, data);
    }

    protected HttpResponse serverUnavailable(String reasonPhrase, Object data){
        return new HttpResponse(HttpStatusCode.SERVER_UNAVAILABLE.getCode(), reasonPhrase, data);
    }
}
