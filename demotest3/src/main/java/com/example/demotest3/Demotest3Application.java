package com.example.demotest3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("package com.example.demotest3.mapper")
public class Demotest3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demotest3Application.class, args);
    }

}
