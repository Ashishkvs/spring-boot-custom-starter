package com.omsent.coreservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public ResponseEntity<?> getUserProfile() {

        Map<String,String> response = new HashMap<>();
        response.put("user","Ashish");
        return ResponseEntity.ok(response);
    }
}