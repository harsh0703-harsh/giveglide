package org.microservice.services;

import jakarta.ws.rs.BadRequestException;
import org.microservice.config.JwtService;
import org.microservice.dto.RegisterDto;
import org.microservice.enums.Role;
import org.microservice.models.UserModel;
import org.microservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private  final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public  AuthService(UserRepository userRepository , ModelMapper modelMapper, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){

        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;

    }

    public UserModel saveUser(RegisterDto user){

        String password = this.passwordEncoder.encode(user.password);
        user.password = password;

        UserModel isUserExist = userRepository.findByEmailAndGuestCheckout(user.email , false);

        if(isUserExist!=null){

            throw new BadRequestException("User already Registered");

        }
        UserModel userModel =  modelMapper.map(user,UserModel.class);

        userModel.setRole(Role.USER);
        userModel.setUserGuestCheckout(false);
        userModel.setVerificationCode(generateVerificationCode());

        return userRepository.save(userModel);

    }

    public String authenticate(String email , String password){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email , password
                )
        );
        UserModel user = userRepository.findByEmail(email);
        return jwtService.generateToken(user);


    }

    private int generateVerificationCode(){

        Random random = new Random();
        int min = 1000;
        int max = 99999;
        return random.nextInt(max-min + 1) + min;

    }


    public UserModel verify(String email , Integer code ){

        UserModel record = userRepository.findByEmailAndVerificationCode(email , code);

        if(record==null) {

            throw new BadRequestException("Invalid Code");

        }

        record.setVerified();
        return userRepository.save(record);

    }

}
