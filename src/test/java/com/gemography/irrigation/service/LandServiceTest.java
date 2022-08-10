package com.gemography.irrigation.service;

import com.gemography.irrigation.dataprovider.LandDataProvider;
import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.LandDTO;
import com.gemography.irrigation.exception.BadRequestException;
import com.gemography.irrigation.exception.ResourceNotFoundException;
import com.gemography.irrigation.repository.LandRepository;
import com.gemography.irrigation.service.impl.LandServiceImpl;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

/**
 *
 * @author AAdekeye
 */
@ExtendWith(MockitoExtension.class)
public class LandServiceTest {
    
    @Mock
    private LandRepository repository;
    
//    @Mock
//    private IotDeviceRepository iotDeviceRepository;
    
    @Mock
    private LandConfigurationService  landConfigurationService;
    
    @InjectMocks
    private LandServiceImpl  landService;
    
    @Spy
    private ModelMapper modelMapper;
    
    @Test
    public void addLand_codeAlreadyExists_expectException(){
        
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        
        when(repository.findByCode(landDto.getCode()))
                .thenReturn(Optional.of(new Land()));
        
        assertThatThrownBy(()-> this.landService.addLand(landDto))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Land code already exists");
        
        verify(repository).findByCode(any());
    }
    
    @Test
    public void addLand_codeNotExists_expectReturnNewLand(){
        
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        Long id = (long)3;
        Land land = LandDataProvider.getLandFromLandDTO(landDto,id);
        
        when(repository.findByCode(landDto.getCode()))
                .thenReturn(Optional.empty());
        
        when(repository.save(any()))
                .thenReturn(land);
        
        this.landService.addLand(landDto);
      
        verify(repository).findByCode(any());
        verify(repository).save(any());
    }
    
    
    @Test
    public void editLand_IdNotFound_expectException(){
        
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        Long id = (long)3;
        
        when(repository.findById(id))
                .thenReturn(Optional.empty());
        
        assertThatThrownBy(()-> this.landService.editLand(landDto,id))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Land not found");
        
        verify(repository).findById(any());
    }
    
    @Test
    public void editLand_idExists_expectReturnUpdatedLand(){
        
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        Long id = (long)3;
        Land land = LandDataProvider.getLandFromLandDTO(landDto,id);
        
        when(repository.findById(id))
                .thenReturn(Optional.of(land));
        
        when(repository.save(any()))
                .thenReturn(land);
        
        this.landService.editLand(landDto,id);
      
        verify(repository).findById(any());
        verify(repository).save(any());
    }
    
    @Test
    public void configureLand_IdNotFound_expectException(){
        
        var configureDto = LandDataProvider.getDefaultConfigureDTO();
        Long id = (long)3;
        
        when(repository.findById(id))
                .thenReturn(Optional.empty());
       
        assertThatThrownBy(()-> this.landService.configureLand(configureDto,id))
                .isInstanceOf(BadRequestException.class)
                .hasMessage("Land not found");
        
        verify(repository).findById(any());
    }
    
    @Test
    public void configureLand_idExists_expectReturnLandConfigure(){
        
        var configureDto = LandDataProvider.getDefaultConfigureDTO();
        Long id = (long)3;
        Land land = new Land();        
        
        when(repository.findById(id))
                .thenReturn(Optional.of(land));
                
        when(landConfigurationService.configureLand(configureDto,land))
                .thenReturn(new LandConfiguration());
               
        this.landService.configureLand(configureDto,id);
      
        verify(repository).findById(any());
        verify(landConfigurationService).configureLand(any(),any());
    }
    
     @Test
    public void getLand_IdNotFound_expectException(){
        
        Long id = (long)3;
        when(repository.findById(id))
                .thenReturn(Optional.empty());
       
        assertThatThrownBy(()-> this.landService.getLandById(id))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Land not found");
        
        verify(repository).findById(any());
    }
    
    @Test
    public void getLand_IdExist_expectReturnLand(){
        
        Long id = (long)3;
        Land land = new Land();  
        when(repository.findById(id))
                .thenReturn(Optional.of(land));
       var retLand = this.landService.getLandById(id);
       assertEquals(land,retLand);
       verify(repository).findById(any());
    }
    
    @Before
    public void setup() throws Exception {    
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
}
