package com.example.appfirebasedemofcm.appfirebasedemofcm;

public class ChatMode {
    public String message;
    public String id;

    public ChatMode() {
    }

    public ChatMode(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
