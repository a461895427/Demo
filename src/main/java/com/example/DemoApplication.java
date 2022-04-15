package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Rewrite
 */
@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("应用已经准备就绪 ... 启动浏览器");
        String url = "http://localhost:8080";
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd   /c   start   " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
