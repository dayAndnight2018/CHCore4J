package com.chenghua.web;

public enum HttpStatusCode {

    SUCCESS(200, "Success"),
    NO_CONTENT(204, "No Content"),

    MOVE_PERMANENTLY(301, "Move Permanently"),
    MOVE_TEMPORARILY(302, "Move Temporarily"),
    NOT_MODIFIED(304, "Not Modified"),

    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_FOUND(405, "Method Not Allowed"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVER_UNAVAILABL(503, "Service Unavailable");

    HttpStatusCode(int statusCode, String reason){
        code = statusCode;
        reasonPhrase = reason;
    }

    public int getCode() {
        return code;
    }
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    private int code;
    private String reasonPhrase;
}
