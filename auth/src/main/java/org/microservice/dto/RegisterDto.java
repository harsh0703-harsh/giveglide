package org.microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class RegisterDto {


    @NotNull(message = "firstName is required")
    @NotEmpty(message = "firstName is required")
    public String firstName ;

    @NotNull(message = "lastName is required")
    @NotEmpty(message = "lastName is required")
    public String lastName ;

    @NotNull(message = "email is required")
    @Email(message = "should be in email format")
    @NotEmpty(message = "email is required")
    public String email ;

    @NotNull(message = "password is required")
    @NotEmpty(message = "password is required")
    public String password ;

}
