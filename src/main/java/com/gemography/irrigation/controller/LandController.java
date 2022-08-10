package com.gemography.irrigation.controller;

import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.dto.LandDTO;
import com.gemography.irrigation.service.LandService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/land")
public class LandController {
    
    private final LandService landService;
    private final ModelMapper modelMapper;

    
    @PostMapping("")
    public ResponseEntity<Land> add(@Valid @RequestBody LandDTO model){
        Land drone = landService.addLand(model);
        return new ResponseEntity<>(drone,HttpStatus.OK); 
    }
    
    @PutMapping("{landId}")
    public ResponseEntity<Land> edit(@Valid @RequestBody LandDTO model,@PathVariable Long landId){
        Land drone = landService.editLand(model,landId);
        return new ResponseEntity<>(drone,HttpStatus.OK); 
    }
    
    
    @PostMapping("{landId}/configure")
    public ResponseEntity<LandDTO> configure(@Valid @RequestBody ConfigureLandDTO model,@PathVariable Long landId){
        Land land = landService.configureLand(model,landId);
        var landDTO = modelMapper.map(land, LandDTO.class);
        return new ResponseEntity<>(landDTO,HttpStatus.OK); 
    }
    
    @GetMapping("")
    public ResponseEntity<List<LandDTO>> gets(){
        List<Land> lands = landService.getAllLands();
        
        List<LandDTO> dto = lands.stream().map(m-> modelMapper.map(m, LandDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    
}
