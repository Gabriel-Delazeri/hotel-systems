package com.delazeri.reserveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReserveServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReserveServiceApplication.class, args);
    }

}
