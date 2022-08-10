package com.gemography.irrigation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemography.irrigation.dataprovider.LandDataProvider;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.LandDTO;
import com.gemography.irrigation.service.LandService;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
public class LandControllerTest {
    
    @Autowired
    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;
    
    @SpyBean
    protected ModelMapper modelMapper;
    
    @SpyBean
    protected LandService landService;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }
    
    
    @Test
    void addLand_validRequest_expectOkContent() throws Exception {
        
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
               
        mvc.perform(post("/api/v1/land")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(landDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(landDto.getCode())))
                .andExpect(jsonPath("$.landType", is(landDto.getLandType())));
        
        verify(landService).addLand(any());
    }
    
    @Test
    void editLand_validRequest_expectOkContent() throws Exception {
        
        Long id = (long)3;
        LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        Land land = LandDataProvider.getLandFromLandDTO(landDto,id);
        
        landDto.setLandType("sandy soil");
        
       
        mvc.perform(put("/api/v1/land/"+land.getId())
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(landDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(landDto.getCode())))
                .andExpect(jsonPath("$.landType", is(landDto.getLandType())));
        
        verify(landService).editLand(any(),any());
    }
    
    @Test
    void configureLand_validRequest_expectOkContent() throws Exception {
        Long id = (long)4;
        ///LandDTO landDto = LandDataProvider.getDefaultLandDTO();
        var landConfigure = LandDataProvider.getDefaultConfigureDTO();
                
        mvc.perform(put("/api/v1/land/"+id+"/configure"))
                .andExpect(status().isOk());

        
        verify(landService).configureLand(landConfigure, id);
    }
    
    @Test
    void getLandDetails_validRequest_expectOkContent() throws Exception {
        
        String url = "/api/v1/land/";
               
        mvc.perform(get(url))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.batteryLevel", is(BATTERY_LEVEL)));
        
        verify(landService).getAllLands();
    }
    
    
  
    
   
    
}
