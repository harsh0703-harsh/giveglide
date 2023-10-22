package org.microservice.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDto {

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email should be string")
    public String email;

    @NotNull()
    @NotEmpty()
    public String password;

}
