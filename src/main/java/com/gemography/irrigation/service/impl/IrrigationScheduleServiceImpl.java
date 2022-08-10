package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.IrrigationSchedule;
import com.gemography.irrigation.domain.enums.IrrigationStatus;
import com.gemography.irrigation.repository.IrrigationScheduleRepository;
import com.gemography.irrigation.service.AlertService;
import com.gemography.irrigation.service.IrrigationScheduleService;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.gemography.irrigation.service.IotDeviceControllerService;
import com.gemography.irrigation.service.LandConfigurationService;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class IrrigationScheduleServiceImpl implements IrrigationScheduleService {
     
    private final IrrigationScheduleRepository repository;
    private final LandConfigurationService  landConfigurationService;
    private final AlertService  alertService;
    private final IotDeviceControllerService  iotDeviceControllerService;
    private final ModelMapper modelMapper;
    
    @Value("${number.of.sensor.retries}")
    private int numberOfSensorRetries;
    
    @Override
    public IrrigationSchedule createSchedule(LandConfiguration config) {
        
        IrrigationSchedule schedule = new IrrigationSchedule();
        schedule.setCreatedOn(new Date());
        schedule.setAmountOfWater(config.getAmountOfWater());
        schedule.setDurationInMinutes(config.getDurationInMinutes());
        schedule.setLandConfiguration(config);
        repository.save(schedule);
        return schedule;
    }

    @Override
    public IrrigationSchedule executeSchedule(IrrigationSchedule schedule) {
        
        var status = iotDeviceControllerService.sendIrrigationSchedule(schedule);
        var retries = 0;
        while(status == IrrigationStatus.NOTAVAILABLE && retries < numberOfSensorRetries){
            status = iotDeviceControllerService.sendIrrigationSchedule(schedule);
            retries++;
        }
        
        //// implement alert after exceeding retry and status is still not available
        if(status == IrrigationStatus.NOTAVAILABLE){
            alertService.sendIotDeviceNotAvailableAlert(schedule.getLandConfiguration().getDeviceName());
        }
        schedule.setStatus(status);
        repository.save(schedule);
        return schedule;
    }
    
}
