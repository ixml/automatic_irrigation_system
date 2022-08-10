package com.gemography.irrigation.service;

import com.gemography.irrigation.domain.IrrigationSchedule;
import com.gemography.irrigation.domain.enums.IrrigationStatus;

/**
 *
 * @author AAdekeye
 */
public interface IotDeviceControllerService {
    
    IrrigationStatus sendIrrigationSchedule(IrrigationSchedule irrigationSchedule);
    
}
