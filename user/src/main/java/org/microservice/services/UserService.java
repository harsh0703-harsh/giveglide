package org.microservice.services;
import org.microservice.config.JwtService;
import org.microservice.dto.UserDto;
import org.microservice.enums.Role;
import org.microservice.models.UserModel;
import org.microservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public  UserService(UserRepository userRepository , ModelMapper modelMapper, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


}
