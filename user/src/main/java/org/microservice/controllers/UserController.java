package org.microservice.controllers;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.microservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("hii")
    @PreAuthorize("hasRole('USER')")
    public String sayHi(HttpServletRequest request){

        Claims claims = (Claims) request.getAttribute("claims");

        System.out.println(claims);

        return "hi to java";
    }



}
