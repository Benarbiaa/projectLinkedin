package com.fsb.linkedinProject.Models;

import java.time.LocalDateTime;

public class Message {
    private int idMessage;
    private User sender;
    private User receiver;
    private String text;
    private LocalDateTime date;

    public Message(int idMessage, User sender, User receiver, String text, LocalDateTime date) {
        this.idMessage = idMessage;
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = date;
    }

    public Message(User sender, User receiver, String text, LocalDateTime date) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.date = date;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
