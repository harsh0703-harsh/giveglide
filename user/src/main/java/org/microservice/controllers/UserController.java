package org.microservice.controllers;
import jakarta.validation.Valid;
import org.microservice.dto.UserDto;
import org.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("hii")
    public String sayHi(){

        return "hi to java";
    }

    @PostMapping("/create")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserDto userDto) {

        UserDto record =this.userService.saveUser(userDto);
        return ResponseEntity.ok(record);
    }
}
