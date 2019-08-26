package com.zzl.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GcApplication {
    public static void main(String[] args) {
        SpringApplication.run(GcApplication.class, args);
    }
}
