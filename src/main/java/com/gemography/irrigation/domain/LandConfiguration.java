package com.gemography.irrigation.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author AAdekeye
 */
@Entity
@Table(name = "landconfigurations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LandConfiguration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Land land; 
    
}
