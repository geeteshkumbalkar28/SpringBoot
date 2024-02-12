package com.login.loginDemo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UserDto {

    @Pattern(regexp = "^[A-Z][A-Za-z]{1,}$",message = "firstName invalid ")
    @NotEmpty(message = "firstName connot empty")
    public String firstName;
    public String lastName;

    @Email
    public String email;
    public String mobileNo;

    public String password;
}
