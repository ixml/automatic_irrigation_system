package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.domain.IrrigationSchedule;
import com.gemography.irrigation.domain.enums.IrrigationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gemography.irrigation.service.IotDeviceControllerService;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
public class MockIotDeviceControllerServiceImpl implements IotDeviceControllerService {

    @Override
    public IrrigationStatus sendIrrigationSchedule(IrrigationSchedule irrigationSchedule) {
        IrrigationStatus[] expectedStatus = new IrrigationStatus[]{IrrigationStatus.FAILED, IrrigationStatus.SUCCESSFUL, IrrigationStatus.NOTAVAILABLE};
                
        ///get random integer between 0 and 1;
        int rand = (int)(Math.random() * 2) + 0;
        IrrigationStatus status = expectedStatus[rand];
        ///connect to the irrigation sensor service to send irrigation schedule
        return status;
    }
    
}
