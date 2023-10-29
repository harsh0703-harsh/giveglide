package org.microservice.controllers;


import jakarta.validation.Valid;
import org.microservice.dto.LoginDto;
import org.microservice.dto.RegisterDto;
import org.microservice.models.UserModel;
import org.microservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@Valid @RequestBody RegisterDto userDto) {

        UserModel record =this.authService.saveUser(userDto);

        return ResponseEntity.ok(record);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto){

        String token = this.authService.authenticate(loginDto.email,loginDto.password);

        return ResponseEntity.ok(token);

    }

    @GetMapping("/verify/{email}/{code}")
    public ResponseEntity<?> verify( @PathVariable String email, @PathVariable Integer code){
        UserModel record = this.authService.verify(email , code);
        return ResponseEntity.ok(record) ;
    }


}
