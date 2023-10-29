package org.microservice.controllers;


import jakarta.validation.Valid;
import org.microservice.dto.OnboardingDto;
import org.microservice.models.CharityModel;
import org.microservice.services.CharityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/charity")
public class CharityController {


    private final CharityService charityService;

    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUserAsCharity(@Valid @RequestBody OnboardingDto onboardingDto){

        CharityModel charity = this.charityService.saveCharity(onboardingDto);

        return ResponseEntity.ok(charity);

    }
}
