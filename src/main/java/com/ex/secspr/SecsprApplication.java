package com.ex.secspr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ex.secspr"})
public class SecsprApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecsprApplication.class, args);
    }

}
