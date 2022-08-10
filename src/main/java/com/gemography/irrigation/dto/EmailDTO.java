package com.gemography.irrigation.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AAdekeye
 */
@Getter
@Setter
public class EmailDTO {
    
    private String to;
    private String from;
    private String fromName;
    private String subject;
    private String body;
    private boolean html;
    
}
