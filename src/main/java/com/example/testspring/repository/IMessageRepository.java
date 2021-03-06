package com.example.testspring.repository;

import com.example.testspring.model.MessageChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<MessageChat, Long> {
    List<MessageChat> findAllByReceiptVer_IdAndSender_Id(Long receiptVer, Long sender);
}
