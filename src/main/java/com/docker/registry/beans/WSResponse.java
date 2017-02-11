package com.docker.registry.beans;

/**
 * @author abhishekrai
 * @since 11/02/2017
 */
public class WSResponse implements DefaultResponse {
    private String message;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DefaultResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
