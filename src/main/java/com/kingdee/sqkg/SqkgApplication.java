package com.kingdee.sqkg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启定时任务
@MapperScan("com.kingdee.sqkg.mapper")
public class SqkgApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqkgApplication.class, args);
    }

}
