/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gemography.irrigation.service;

import com.gemography.irrigation.domain.LandConfiguration;
import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.dto.LandDTO;
import java.util.List;

/**
 *
 * @author AAdekeye
 */
public interface LandConfigurationService {
    
    /**
     * add a new land
     *
     * @param model LandDTO must not be {@literal null}.
     * @return never {@literal null}.
     */
    LandConfiguration configureLand(ConfigureLandDTO model,Land land);
    
    List<LandConfiguration> getConfigurationSchedules();
    
    LandConfiguration updateNextTimeSlot(LandConfiguration configuration);
}
