package com.lab.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Equivalent to writing 3 annotations by hand:
//   @Configuration        <- this is a configuration class
//   @ComponentScan        <- scan all sub-packages from here
//   @EnableAutoConfiguration <- Spring Boot auto-configures from the classpath
public class Lab3Application {
    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }
}
