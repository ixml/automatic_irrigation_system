/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.dto.EmailDTO;
import com.gemography.irrigation.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    
    private JavaMailSender javaMailSender;
    

    @Override
    public void SendMail(EmailDTO mail) {
        
        SimpleMailMessage msg = new SimpleMailMessage(); 
        msg.setTo(mail.getTo());
        msg.setSubject(mail.getSubject());
        msg.setText(mail.getBody());
        
        javaMailSender.send(msg);
    }
    
}
