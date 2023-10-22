package org.microservice.controllers;
import jakarta.validation.Valid;
import org.microservice.dto.LoginDto;
import org.microservice.dto.UserDto;
import org.microservice.enums.Role;
import org.microservice.guards.RoleGuard;
import org.microservice.models.UserModel;
import org.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RoleGuard({Role.USER,Role.SADMIN})
    @GetMapping("hii")
    public String sayHi(){

        return "hi to java";
    }



}
