package com.flight_reservation_app.utilities;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender sender;

    public void sendItinerary(String toAddress, String filePath) {
        System.out.println("Sending email with attachment: " + filePath);

        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary Of Flight");
            messageHelper.setText("Please find the attached itinerary.");

            // Validate if the file exists before adding as an attachment
            File attachmentFile = new File(filePath);
            if (attachmentFile.exists()) {
                messageHelper.addAttachment("Itinerary", attachmentFile);
                sender.send(message);
                System.out.println("Email sent successfully.");
            } else {
                System.out.println("Attachment file not found: " + filePath);
            }
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
