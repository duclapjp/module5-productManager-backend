package com.example.testspring.controller;

import com.example.testspring.model.MessageChat;
import com.example.testspring.service.messageChat.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @GetMapping("/messages/{receiptVer}/{sender}")
    public ResponseEntity<List<MessageChat>> findAllMessages(@PathVariable Long receiptVer, @PathVariable Long sender){
        List<MessageChat> messageChats = messageService.findAllByReceiptVer_IdAndSender_Id(receiptVer,sender);
        return new ResponseEntity<>(messageChats, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<MessageChat> save(@RequestBody MessageChat messageChat){
        return new ResponseEntity<>(messageService.save(messageChat),HttpStatus.OK);
    }
}
