package com.edureka.spring.springconfigurations.demo2.beanconfiguration;

import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@PropertySource(value = { "classpath:application.properties" })
public class Configuration {
}
