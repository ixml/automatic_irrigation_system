package com.gemography.irrigation.repository;

import com.gemography.irrigation.domain.IrrigationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AAdekeye
 */
@Repository
public interface IrrigationScheduleRepository extends JpaRepository<IrrigationSchedule, Long> {
    
    
    
}
