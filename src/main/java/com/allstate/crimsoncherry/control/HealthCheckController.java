package com.allstate.crimsoncherry.control;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@CrossOrigin
@RestController
@CrossOrigin
public class HealthCheckController {

    @GetMapping("/api/healthcheck")
    public String systemIsHealthy() {
        LocalDateTime now = LocalDateTime.now();
        return now + " - healthy!";
    }
}
