package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.dto.EmailDTO;
import com.gemography.irrigation.service.AlertService;
import com.gemography.irrigation.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AlertServiceImpl implements AlertService {
    
    private final EmailService emailService;
    
    @Value("${admin.email}")
    private String adminEmail;


    @Override
    public void sendIotDeviceNotAvailableAlert(String deviceName) {
        log.info("sending iot device not available alert");
        var mail = new EmailDTO();
        mail.setTo(adminEmail);
        mail.setSubject("Iot Device Not Available Alert");
        String message = "IotDevice with name %s is not available";
        mail.setBody(String.format(message, deviceName));
    
        emailService.SendMail(mail);     
    }
    
}
