package com.gemography.irrigation.service;

import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.dto.LandDTO;
import java.util.List;

/**
 *
 * @author AAdekeye
 */
public interface LandService {
    
    /**
     * add a new land
     *
     * @param model LandDTO must not be {@literal null}.
     * @return never {@literal null}.
     */
    Land addLand(LandDTO model);
    

    /**
     * edit an existing land
     *
     * @param model LandDTO must not be {@literal null}.
     * @param id Integer.
     * @return never {@literal null}.
     */
    Land editLand(LandDTO model,Long id);
    
    Land configureLand(ConfigureLandDTO model,Long id);
    /**
     * Returns specified category as well as all descendents
     * @param id parent category id
     * @return specified category and descendents
     */
    Land getLandById(Long id); 
    List<Land> getAllLands(); 
    
}
