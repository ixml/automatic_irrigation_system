package com.gemography.irrigation.service.impl;

import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.dto.LandDTO;
import com.gemography.irrigation.exception.BadRequestException;
import com.gemography.irrigation.exception.ResourceNotFoundException;
import com.gemography.irrigation.repository.LandRepository;
import com.gemography.irrigation.service.LandService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.gemography.irrigation.service.LandConfigurationService;

/**
 *
 * @author AAdekeye
 */
@Service
@RequiredArgsConstructor
public class LandServiceImpl implements LandService {
    
    private final LandRepository repository;
    private final LandConfigurationService  iotDeviceService;
    private final ModelMapper modelMapper;

    @Override
    public Land addLand(LandDTO model) {
        
        ///check if land code already exists         
        Optional<Land> land = repository.findByCode(model.getCode());
        
        if(land.isPresent()){
            throw new BadRequestException("Land code already exists");
        }
        
        Land entity = modelMapper.map(model, Land.class);
        entity.setCreatedOn(new Date());
        repository.save(entity);
        return entity;  
    }

    @Override
    public Land editLand(LandDTO model, Long id) {
        Optional<Land> land = repository.findById(id);
        
        if(!land.isPresent()){
            throw new BadRequestException("Land not found");
        }
        Land entity = land.get();
        entity.setCode(model.getCode());
        entity.setAgricType(model.getAgricType());
        entity.setArea(model.getArea());
        entity.setLandType(model.getLandType());
        
        entity.setModifiedOn(new Date());
        repository.save(entity);
        return entity;  
    }

    @Override
    public Land configureLand(ConfigureLandDTO model,Long id) {
        Optional<Land> land = repository.findById(id);
        
        if(land.isEmpty()){
            throw new BadRequestException("Land not found");
        }
                
        iotDeviceService.configureLand(model, land.get());     
        return land.get();   
    }

    @Override
    public Land getLandById(Long id) {
        Optional<Land> land = repository.findById(id);    
        if(land.isEmpty()){
            throw new ResourceNotFoundException("Land not found");
        }  
        return land.get();
    }

    @Override
    public List<Land> getAllLands() {
        return repository.findAll();
    }
    
}
