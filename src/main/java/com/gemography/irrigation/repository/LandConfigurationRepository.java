package com.gemography.irrigation.repository;

import com.gemography.irrigation.domain.LandConfiguration;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AAdekeye
 */
@Repository
public interface LandConfigurationRepository extends JpaRepository<LandConfiguration, Long> {
    
    List<LandConfiguration> findByNextTimeSlotEquals(Date timeSlot);
    
}
