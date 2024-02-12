package com.login.loginDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "UserInfo")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer userId;

    private String firstName;
    private String lastName;

    private String email;
    private String mobileNo;
    private Integer otp;
    private Boolean verifyStatus;
    private String password;



}
