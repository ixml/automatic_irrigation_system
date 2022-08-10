package com.gemography.irrigation.dto;

import com.gemography.irrigation.domain.LandConfiguration;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author AAdekeye
 */

@Getter
@Setter
public class LandDTO {
    
    private Long id;
    
    @Size(max=100,message="Land code is too long")
    private String code;
    
    @NotEmpty
    private String landType;
    
    @NotEmpty
    private String agricType;
    
    @Min(1)
    private float area;
    
    private List<LandConfigurationDTO> landConfigurations;
    
}
