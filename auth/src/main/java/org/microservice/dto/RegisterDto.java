package org.microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class RegisterDto {


    @NotNull(message = "first_name is required")
    @NotEmpty(message = "first_name is required")
    public String first_name ;

    @NotNull(message = "first_name is required")
    @NotEmpty(message = "last_name is required")
    public String last_name ;

    @NotNull(message = "first_name is required")
    @Email(message = "should be in email format")
    @NotEmpty(message = "email is required")
    public String email ;

    @NotNull(message = "password is required")
    @NotEmpty(message = "password is required")
    public String password ;

}
