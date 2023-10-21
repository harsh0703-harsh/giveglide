package org.microservice.services;

import org.microservice.dto.UserDto;
import org.microservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto user){

        System.out.println(user);

        return user;
    }

}
