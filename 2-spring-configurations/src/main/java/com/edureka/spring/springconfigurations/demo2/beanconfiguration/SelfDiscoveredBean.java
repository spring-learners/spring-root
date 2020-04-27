package com.edureka.spring.springconfigurations.demo2.beanconfiguration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
public class SelfDiscoveredBean {

    @Value("${server.port}")
    Integer serverPort;
}
