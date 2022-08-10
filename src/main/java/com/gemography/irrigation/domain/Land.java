
package com.gemography.irrigation.domain;


import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "lands")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Land {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true)
    private String code;
    
    private float area;
    
    private String landType;
    
    private String agricType;
     
    private Date createdOn;
    private Date modifiedOn;
    
    @OneToMany(mappedBy="land")
    private List<LandConfiguration> landConfigurations;
}
