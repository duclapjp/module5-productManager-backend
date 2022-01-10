package com.example.testspring.controller;

import com.example.testspring.model.MessageChat;
import com.example.testspring.model.Product;
import com.example.testspring.service.messageChat.IMessageChatService;
import com.example.testspring.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.SortDefault;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
public class WebsocketController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IMessageChatService messageChatService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/products")
    @SendTo("/topic/product")
    public Product createNewProduct(Product product){
        return productService.save(product);
    }

    @MessageMapping("/messages")
    public void createMessage(MessageChat messageChat){
        String receiptId = String.valueOf(messageChat.getReceiptVer().getId());
        messageChat.setTime(LocalDateTime.now());
        simpMessagingTemplate.convertAndSend("/topic/message/"+receiptId,messageChatService.save(messageChat));
    }
}
