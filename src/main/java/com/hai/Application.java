package com.hai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by chenz at 19:33 on 2021/3/15
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.hai.listener.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}