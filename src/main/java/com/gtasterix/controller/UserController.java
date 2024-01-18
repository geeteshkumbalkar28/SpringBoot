package com.gtasterix.controller;


import com.gtasterix.Interface.IUser;
import com.gtasterix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUser iUser;

    @PostMapping("/insertUser")
    public User insertData(@RequestBody User user){
        User user1 = iUser.save(user);

        return user1;
    }
    @GetMapping("/display")
    public List<User> displayAll(){
        return iUser.displayAll();

    }

    @PutMapping("/update")
    public User update(){

    }

    @DeleteMapping("/delete")
    public String delete(){

    }



}
