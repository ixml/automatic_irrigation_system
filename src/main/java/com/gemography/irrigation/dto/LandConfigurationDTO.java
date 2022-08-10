package com.gemography.irrigation.dto;

import java.util.Date;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AAdekeye
 */
@Getter
@Setter
public class LandConfigurationDTO {

    private Long id;
    
    @Pattern(regexp="^[A-Za-z0-9-_]*$",message="Invalid name")
    private String deviceName;
    
    private Date timeSlot;
    
    private Integer intervalInDays;
    
    private Integer durationInMinutes;
        
    private Integer amountOfWater;
    
    private Date nextTimeSlot;
    
    private Date createdOn;
    private Date modifiedOn;
}
