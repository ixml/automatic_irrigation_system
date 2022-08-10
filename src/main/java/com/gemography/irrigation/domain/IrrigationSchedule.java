package com.gemography.irrigation.domain;

import com.gemography.irrigation.domain.enums.IrrigationStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
         
    ///private Date timeSlot;
    
    private Integer durationInMinutes;
    
    private Integer amountOfWater;
    
    @Enumerated(EnumType.STRING)
    private IrrigationStatus status;
       
    @ManyToOne(fetch = FetchType.LAZY)
    private LandConfiguration landConfiguration;
    
    private Date createdOn;
    private Date modifiedOn;
}
