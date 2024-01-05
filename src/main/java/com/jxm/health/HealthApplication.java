package com.jxm.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication(scanBasePackages = "com.jxm.health")
@MapperScan("com.jxm.health.mapper")
@EnableOpenApi
public class HealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class,args);
    }

}
