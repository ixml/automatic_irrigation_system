package com.gemography.irrigation.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AAdekeye
 */
@Getter
@Setter
public class AlertDTO {
    
    @NotEmpty
    private String recipient;
    
    @NotEmpty
    private String message;
    
    @NotEmpty
    private boolean isHtml;
       
}
