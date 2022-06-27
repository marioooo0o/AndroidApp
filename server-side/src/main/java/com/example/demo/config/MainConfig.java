package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Autowired
    LectureConfig lectureConfig;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            lectureConfig.seed();
        };
    }
}
