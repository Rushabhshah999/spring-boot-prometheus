package com.example.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    private final Counter requestCounter;

    public DemoApplication(MeterRegistry registry) {
        // Create a custom metric
        this.requestCounter = Counter.builder("myapp_requests_total")
                .description("Total number of API requests handled")
                .register(registry);
    }

    @GetMapping("/hello")
    public String hello() {
        requestCounter.increment();
        return "Hello from Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
