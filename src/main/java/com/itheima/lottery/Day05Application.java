package com.itheima.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Day05Application {

    public static void main(String[] args) {
        SpringApplication.run(Day05Application.class, args);
    }
}
