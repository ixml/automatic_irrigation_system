package com.gemography.irrigation.service;

import com.gemography.irrigation.dataprovider.LandDataProvider;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.dto.LandDTO;
import com.gemography.irrigation.exception.BadRequestException;
import com.gemography.irrigation.repository.LandConfigurationRepository;
import com.gemography.irrigation.repository.LandRepository;
import com.gemography.irrigation.service.impl.LandConfigurationServiceImpl;
import com.gemography.irrigation.service.impl.LandServiceImpl;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

/**
 *
 * @author AAdekeye
 */

@ExtendWith(MockitoExtension.class)
public class LandConfigurationServiceTest {
     
    @Mock
    private LandConfigurationRepository repository;
    
    
    @InjectMocks
    private LandConfigurationServiceImpl  landConfigurationService;
    
    @Spy
    private ModelMapper modelMapper;
    
     @Test
    public void configureLand_idExists_expectReturnLandConfigure(){
        
        var configureDto = LandDataProvider.getDefaultConfigureDTO();
        Long id = (long)3;
        Land land = new Land();                      
        this.landConfigurationService.configureLand(configureDto,land);
        verify(repository).save(any());
    }
}
