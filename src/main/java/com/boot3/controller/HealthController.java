package com.boot3.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="[Common] Health Controller", description="Health Controller 구현하기")

public class HealthController {

    @GetMapping("/health")
    @Operation(description = "Application Health Info 조회하기")
    public String healthInfo(){
        return "health";
    }
}
