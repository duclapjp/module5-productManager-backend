package com.example.testspring.service.messageChat;

import com.example.testspring.model.MessageChat;
import com.example.testspring.repository.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageChatService{
    @Autowired
    private IMessageRepository messageRepository;




    @Override
    public MessageChat save(MessageChat messageChat) {
        return messageRepository.save(messageChat);
    }

    @Override
    public List<MessageChat> findAllByReceiptVer_IdAndSender_Id(Long receiptVer, Long sender) {
        return messageRepository.findAllByReceiptVer_IdAndSender_Id(receiptVer,sender);
    }
}
