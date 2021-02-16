package com.example.exelondemo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoConfigProperties.class)
public class DemoConfig {
}
