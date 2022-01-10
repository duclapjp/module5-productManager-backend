package com.example.testspring.controller;

import com.example.testspring.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@EnableScheduling
public class MailerController {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ProductService productService;

    @Scheduled(cron = "0 52 20 * * ?")
    public void sendEmail() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate dayPlusAWeek = LocalDate.now().plusDays(1);
        String day = formatter.format(dayPlusAWeek);

        List<String> listEmailOneTime = productService.getAllEmailToSend();
//        List<String> listEmailOneMoreTime = productService.getEmailToSendOfVaccinationMore();
        Set<String> listEmail = new HashSet<>();
        listEmail.addAll(listEmailOneTime);
//        listEmail.addAll(listEmailOneMoreTime);

        if (!(listEmail.size() == 0)) {
            String[] array = listEmail.toArray(new String[0]);
            // Create a Simple MailMessage.
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(array);
            message.setSubject("Test gửi mail tự động ");
            message.setText("Chào bạn \n"
                    + "Hello anh em vào Mua hàng đi kìa");

            // Send Message!
            this.emailSender.send(message);
        } else {
            System.out.println(day + " Have not email to send!");
        }
    }
}
