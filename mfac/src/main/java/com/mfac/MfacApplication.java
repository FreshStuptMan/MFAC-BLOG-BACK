package com.mfac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MfacApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfacApplication.class, args);
    }

}
