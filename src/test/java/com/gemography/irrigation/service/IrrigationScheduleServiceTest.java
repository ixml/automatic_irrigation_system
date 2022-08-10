package com.gemography.irrigation.service;

import com.gemography.irrigation.dataprovider.LandDataProvider;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.repository.IrrigationScheduleRepository;
import com.gemography.irrigation.repository.LandConfigurationRepository;
import com.gemography.irrigation.service.impl.IrrigationScheduleServiceImpl;
import com.gemography.irrigation.service.impl.LandConfigurationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

/**
 *
 * @author AAdekeye
 */
@ExtendWith(MockitoExtension.class)
public class IrrigationScheduleServiceTest {
    
    @Mock
    private IrrigationScheduleRepository repository;
    
    
    @InjectMocks
    private IrrigationScheduleServiceImpl  irrigationScheduleService;
    
    @Spy
    private ModelMapper modelMapper;
    
    @Test
    public void createSchedule_idExists_expectReturnLandConfigure(){
        
        var configureDto = LandDataProvider.getDefaultConfigureDTO();
        Long id = (long)3;
        Land land = new Land();                      
        this.irrigationScheduleService.createSchedule(new LandConfiguration());
        verify(repository).save(any());
    }
}
