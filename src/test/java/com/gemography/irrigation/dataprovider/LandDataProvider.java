/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gemography.irrigation.dataprovider;

import com.gemography.irrigation.domain.Land;
import com.gemography.irrigation.dto.ConfigureLandDTO;
import com.gemography.irrigation.dto.LandDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author AAdekeye
 */
public class LandDataProvider {
    
    public static final String LAND_CODE = "2722782392889";
    public static final float LAND_AREA = 23348;
    public static final String AGRIC_TYPE = "Rice Farming";
    public static final String LAND_TYPE = "loamy soil";
    
    public static final LandDTO getLandDTO(String code,String landType,String agricType, float area){
        
        LandDTO land = new LandDTO();
        land.setCode(code);
        land.setAgricType(agricType);
        land.setLandType(landType);
        land.setArea(area);
        return land;
    }
    
    public static final LandDTO getDefaultLandDTO(){
        
        LandDTO land = new LandDTO();
        land.setCode(LAND_CODE);
        land.setAgricType(AGRIC_TYPE);
        land.setLandType(LAND_TYPE);
        land.setArea(LAND_AREA);
        return land;
    }
    
    public static final ConfigureLandDTO getDefaultConfigureDTO(){
        
        var calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        var timeSlot =  calendar.getTime();
        ConfigureLandDTO configure = new ConfigureLandDTO();
        configure.setDeviceName("device101");
        configure.setAmountOfWater(3000);
        configure.setDurationInMinutes(3600);
        configure.setTimeSlot(timeSlot);
        configure.setIntervalInDays(3);
        return configure;
    }
    
     public static final Land getLandFromLandDTO(LandDTO dto,Long id){        
        Land land = new Land();
        land.setCode(dto.getCode());
        land.setAgricType(dto.getAgricType());
        land.setLandType(dto.getLandType());
        land.setArea(dto.getArea());
        land.setId(id);
        return land;
    }
     
//    private static final Land getDroneFromDroneDTO(String serialNumber,int battery, int weight, DroneModel model){        
//        Land dr = new Land();
//        dr.setBatteryLevel(battery);
//        dr.setModel(model);
//        dr.setSerialNumber(serialNumber);
//        dr.setWeightLimit(weight);
//        return dr ;
//    }
//    
//    
//    private static final List<MedicationDTO> getMedicationDTO(){      
//        
//        List<MedicationDTO> result = new ArrayList<>();
//        MedicationDTO md = new MedicationDTO();
//        md.setCode("2323323");
//        md.setWeight(100);
//        md.setName("Phizer");
//        md.setImage("base64encodedImage");
//        
//        
//        MedicationDTO md2 = new MedicationDTO();
//        md2.setCode("32232");
//        md2.setWeight(250);
//        md2.setName("Aztrazenica");
//        md2.setImage("base64encodedImage");
//        
//        result.add(md);
//        result.add(md2);
//                
//               
//        return result;
//    }
    
}
