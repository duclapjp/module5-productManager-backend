package com.example.testspring.service.messageChat;

import com.example.testspring.model.MessageChat;
import com.example.testspring.service.IGeneralService;

import java.util.List;

public interface IMessageChatService  {
    List<MessageChat> findAllByReceiptVer_IdAndSender_Id(Long receiptVer, Long sender);

    MessageChat save(MessageChat messageChat);
}
