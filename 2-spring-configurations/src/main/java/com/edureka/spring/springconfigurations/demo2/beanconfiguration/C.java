package com.edureka.spring.springconfigurations.demo2.beanconfiguration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Data
public class C {

    @Value("string value")
    String stringValue;

    private D d;

    @Autowired
    public C(D d){
        this.d = d;
    }
}
