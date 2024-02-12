package com.login.loginDemo.Interface;

import com.login.loginDemo.DTO.UserDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

public interface IUser {
    String signUp(UserDto userDto);

    String login(String email, String password);

    String verify(Integer otp , String email);

    String emailSender(String email) throws MessagingException;
}
