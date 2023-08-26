package com.example.smallcompany.projection;

import com.example.smallcompany.entity.Address;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Address.class)
public interface CastomAdress {
    Integer getId();
    String getStreet();

    String getHomeName();
    

    
}
