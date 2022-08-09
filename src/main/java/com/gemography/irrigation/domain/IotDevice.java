package com.gemography.irrigation.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "iotdevices")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IotDevice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Pattern(regexp="^[A-Za-z0-9-_]*$",message="Invalid name")
    private String name;
    
    private Date startDate;
    
    private Integer intervalInDays;
    
    private Integer duration;
    
    private Integer amountOfWater;
    
    private Date nextSchedule;
    
    private Date createOn;
    private Date modifiedOn;
    
}
