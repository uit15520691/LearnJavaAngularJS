package com.app.models;

public class Response {
    private String action;
    private String message;
    private String email;

    public Response(String action, String message, String email) {
        this.action = action;
        this.message = message;
        this.email = email;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
