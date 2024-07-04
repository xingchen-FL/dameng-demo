package com.cmcc.damengdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cmcc.damengdemo.mapper")
public class DaMengDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaMengDemoApplication.class, args);
    }

}
