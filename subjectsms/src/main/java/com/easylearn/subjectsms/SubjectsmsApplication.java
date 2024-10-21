package com.easylearn.subjectsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubjectsmsApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(65000);
        SpringApplication.run(SubjectsmsApplication.class, args);
    }

}
