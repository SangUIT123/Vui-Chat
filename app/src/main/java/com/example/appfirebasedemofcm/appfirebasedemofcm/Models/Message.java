package com.example.appfirebasedemofcm.appfirebasedemofcm.Models;

public class Message {
    String message;
    String sender;
    String createAt;

    public Message(){

    }

    public Message(String _message, String _sender,  String _CreateAt)
    {
        this.message = _message;
        this.sender = _sender;
        this.createAt = _CreateAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
}
