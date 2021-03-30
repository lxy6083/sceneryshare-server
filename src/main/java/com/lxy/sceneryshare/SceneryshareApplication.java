package com.lxy.sceneryshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxy.sceneryshare.dao")
public class SceneryshareApplication {

    public static void main(String[] args) {
        SpringApplication.run(SceneryshareApplication.class, args);
    }

}
