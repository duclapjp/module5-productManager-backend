package com.example.testspring.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MessageChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne(targetEntity = User.class)
    private User sender;
    @ManyToOne(targetEntity = User.class)
    private User receiptVer;
    private Long status;
    private LocalDateTime time;
    public MessageChat() {
    }

    public MessageChat(String message, User sender, User receiptVer, Long status, LocalDateTime time) {
        this.message = message;
        this.sender = sender;
        this.receiptVer = receiptVer;
        this.status = status;
        this.time = time;
    }

    public MessageChat(Long id, String message, User sender, User receiptVer, Long status, LocalDateTime time) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.receiptVer = receiptVer;
        this.status = status;
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiptVer() {
        return receiptVer;
    }

    public void setReceiptVer(User receiptVer) {
        this.receiptVer = receiptVer;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
