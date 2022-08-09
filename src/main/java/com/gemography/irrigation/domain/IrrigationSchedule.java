package com.gemography.irrigation.domain;

import com.gemography.irrigation.domain.enums.IrrigationStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "irrigationschedules")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationSchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
         
    private Integer duration;
    
    private Integer amountOfWater;
    
    private IrrigationStatus status;
       
    @ManyToOne(fetch = FetchType.LAZY)
    private IotDevice iotDevice;
    
    private Date createOn;
    private Date modifiedOn;
}
