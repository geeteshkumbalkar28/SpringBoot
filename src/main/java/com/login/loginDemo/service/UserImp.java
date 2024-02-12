package com.login.loginDemo.service;

import com.login.loginDemo.DTO.UserDto;
import com.login.loginDemo.Interface.IUser;
import com.login.loginDemo.Repo.IUserRepo;
import com.login.loginDemo.model.User;
import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Properties;
import java.util.Random;

@Service
public class UserImp implements IUser {
    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public String signUp(UserDto userDto) {
        Optional<User> userDetails= iUserRepo.findByEmail(userDto.email);
        if(userDetails.isPresent()){
            throw new RuntimeException("user email already exist");
        }

        Random random = new Random();
        Integer otp = random.nextInt(8999)+1000;
//        8999+1000=9999
        System.out.println("OTP for this user :"+userDto.email+" OTP IS :"+otp);
        User user = new User();
        user.setEmail(userDto.email);
        user.setFirstName(userDto.firstName);
        user.setLastName(userDto.lastName);
        user.setMobileNo(userDto.mobileNo);
        user.setVerifyStatus(false);
        user.setPassword(userDto.password);
        user.setOtp(otp);

        iUserRepo.save(user);

        return "data added verify this account";

    }

    @Override
    public String login(String email, String password) {
        User userDetails= iUserRepo.findByEmail(email).orElseThrow(()->new RuntimeException("email id not found"));
        if (!(userDetails.getPassword()).equals(password)){
            throw new RuntimeException("password incorrect for this : "+email);
        }
        if (!userDetails.getVerifyStatus()){
            throw new RuntimeException(" first verify your account then you should login");
        }

        return "login successful";


    }

    @Override
    public String verify(Integer otp, String email) {
        User userDetails= iUserRepo.findByEmail(email).orElseThrow(()->new RuntimeException("email id not found"));

        if(!otp.equals(userDetails.getOtp())){
            throw new RuntimeException("Otp invalid for this : "+email);
        }
            userDetails.setVerifyStatus(true);
            iUserRepo.save(userDetails);
            return "user verify";




    }

    @Override
    public String emailSender(String email) throws MessagingException {


        Random random = new Random();
        Integer otp = random.nextInt(8999)+1000;
//        8999+1000=9999
        System.out.println("OTP for this user :"+email+" OTP IS :"+otp);

        Properties properties = System.getProperties();

        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.ssl.enable",true);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.host","smtp.gmail.com");
        String userName = "lb13june";
        String password = "your password";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }
        });
    try{
        MimeMessage message = new MimeMessage(session);
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
        message.setFrom("testOne28062000@gmail.com");
        message.setSubject("OTP Verification  ");
        message.setText("OTP Verification  your otp is :"+String.valueOf(otp));

        Transport.send(message);

        return "email send";
    }catch (Exception e){
        e.printStackTrace();

        return "email not send";

    }

    }
}
