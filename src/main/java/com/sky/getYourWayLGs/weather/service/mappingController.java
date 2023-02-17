package com.sky.getYourWayLGs.weather.service;

import org.springframework.web.bind.annotation.GetMapping;

public class mappingController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
