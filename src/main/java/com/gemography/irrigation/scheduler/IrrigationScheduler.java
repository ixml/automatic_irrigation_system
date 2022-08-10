package com.gemography.irrigation.scheduler;

import com.gemography.irrigation.service.IrrigationScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import com.gemography.irrigation.service.LandConfigurationService;


@Component
@RequiredArgsConstructor
@Slf4j
public class IrrigationScheduler  {
    
    private final LandConfigurationService landConfigurationService;
    private final IrrigationScheduleService irrigationScheduleService;
    
    @Scheduled(fixedRateString = "${schedule.in.milliseconds}")
    public void createScheduleFromLandConfig(){
        log.info("Running ");
        var landConfigs = landConfigurationService.getConfigurationSchedules();
        log.info("Number of Schedules "+ landConfigs.size());
        
        for(var landConfig: landConfigs ){
            log.info("Creating schedule for device id "+ landConfig.getDeviceName());
            landConfigurationService.updateNextTimeSlot(landConfig);
            
            var schedule = irrigationScheduleService.createSchedule(landConfig);
            irrigationScheduleService.executeSchedule(schedule);
        }
    }
    
}
