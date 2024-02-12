package com.login.loginDemo.controller;


import com.login.loginDemo.DTO.UserDto;
import com.login.loginDemo.Interface.IUser;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUser iUser;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto){

            try
            {

                String output = iUser.signUp(userDto);
                return ResponseEntity.status(HttpStatus.OK).body(output);
            } catch (RuntimeException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getClass()   );

            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

            }
        }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,@RequestParam String password){

        try
        {

           String output = iUser.login(email,password);
            return ResponseEntity.status(HttpStatus.OK).body(output);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @PutMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam Integer otp,@RequestParam String email){

        try
        {

            String output = iUser.verify(otp,email);
            return ResponseEntity.status(HttpStatus.OK).body(output);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @PostMapping("/email")
    public ResponseEntity<?> emailSend(@RequestParam String email){

        try
        {

            String output = iUser.emailSender(email);
            return ResponseEntity.status(HttpStatus.OK).body(output);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
