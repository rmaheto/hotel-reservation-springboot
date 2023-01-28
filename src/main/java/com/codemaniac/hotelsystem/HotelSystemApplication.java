package com.codemaniac.hotelsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class HotelSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelSystemApplication.class, args);
    }

}
