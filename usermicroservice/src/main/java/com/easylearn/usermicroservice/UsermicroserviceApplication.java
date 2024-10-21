package com.easylearn.usermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@enabledocuments
public class UsermicroserviceApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(75000);
        SpringApplication.run(UsermicroserviceApplication.class, args);
    }

}
