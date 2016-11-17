package de.davidcrome.boot.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SkeletonToProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkeletonToProductionApplication.class, args);
    }

    @RequestMapping("/app-name")
    public String getAppName() {
        return "skeleton-to-production";
    }
}
