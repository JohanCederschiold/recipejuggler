package se.jpdc.receptdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReceptdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceptdemoApplication.class, args);
    }

}

