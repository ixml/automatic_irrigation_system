package com.gemography.irrigation.repository;

import com.gemography.irrigation.domain.Land;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AAdekeye
 */
@Repository
public interface LandRepository extends JpaRepository<Land, Long>  {
    Optional<Land> findByCode(String code);

}
