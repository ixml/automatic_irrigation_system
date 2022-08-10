/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.exception.BadRequestException;
import com.gemography.irrigation.repository.LandRepository;
import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import com.gemography.irrigation.service.LandConfigurationService;
import com.gemography.irrigation.repository.LandConfigurationRepository;
import java.util.Calendar;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
public class LandConfigurationServiceImpl implements LandConfigurationService {

    private final LandConfigurationRepository repository;
    private final ModelMapper modelMapper;
    
    
    @Override
    public LandConfiguration configureLand(ConfigureLandDTO model,Land land) {
                
        if(land==null){
            throw new BadRequestException("Land not found");
        } 
        LandConfiguration device = modelMapper.map(model, LandConfiguration.class);
        
        if(model.getTimeSlot().getTime() < new Date().getTime()){   
            throw new BadRequestException("Invalid date, time slot cannot be in the past");   
        }
        
        device.setLand(land);
        device.setNextTimeSlot(model.getTimeSlot());
        device.setCreatedOn(new Date());
        
        repository.save(device);   
        return device;  
    }

    @Override
    public List<LandConfiguration> getConfigurationSchedules() {
        
        return repository.findByNextTimeSlotEquals(new Date());
    }

    @Override
    public LandConfiguration updateNextTimeSlot(LandConfiguration configuration) {
        
        var calendar = Calendar.getInstance();
        calendar.setTime(configuration.getNextTimeSlot());
        calendar.add(Calendar.HOUR_OF_DAY, configuration.getIntervalInDays());
        var timeSlot =  calendar.getTime();    
        configuration.setNextTimeSlot(timeSlot);
        configuration.setModifiedOn(new Date());
        repository.save(configuration);
        return configuration;
    }
    
}
