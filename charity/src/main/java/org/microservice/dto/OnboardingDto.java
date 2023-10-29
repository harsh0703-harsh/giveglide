package org.microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OnboardingDto {

    @NotNull(message = "email cannot be null")
    @NotEmpty(message = "email cannot be empty")
    @Email()
    public String email;

    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    public  String password;

    @NotNull(message = "type cannot be null")
    @NotEmpty(message = "type cannot be empty")
    public String type;

    @NotNull(message = "type cannot be null")
    @NotEmpty(message = "type cannot be empty")
    public String country;

    @NotNull(message = "regno cannot be null")
    @NotEmpty(message = "regno cannot be empty")
    public  String regno;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    public  String name;

    @NotNull(message = "website cannot be null")
    @NotEmpty(message = "website cannot be empty")
    public  String website;
    public  Object address;  // it will contain address , city , postcode

}
