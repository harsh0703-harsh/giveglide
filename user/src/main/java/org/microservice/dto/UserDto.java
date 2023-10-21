package org.microservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor

public class UserDto {


    @NotEmpty(message = "first_name is required")
    private String first_name ;

    @NotEmpty(message = "last_name is required")
    private String last_name ;

    @Email(message = "should be in email format")
    @NotEmpty(message = "email is required")
    private String email ;
}
