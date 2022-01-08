package com.example.testspring.configure;


import com.example.testspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketService {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    public void sendMessageProduct( Product  jsonString) {
        simpMessagingTemplate.convertAndSend("/topic/product", jsonString);
    }
}
