package com.gemography.irrigation.service;

import com.gemography.irrigation.dto.EmailDTO;

/**
 *
 * @author AAdekeye
 */
public interface EmailService {
    
    void SendMail(EmailDTO mail);
}
