package com.gemography.irrigation.service;

import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.IrrigationSchedule;


/**
 *
 * @author AAdekeye
 */
public interface IrrigationScheduleService {
    
    IrrigationSchedule createSchedule(LandConfiguration device);
    IrrigationSchedule executeSchedule(IrrigationSchedule schedule);
    
}
