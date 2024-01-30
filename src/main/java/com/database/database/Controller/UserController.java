package com.database.database.Controller;


import com.database.database.DTO.UserDto;
import com.database.database.Interface.IUser;
import com.database.database.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUser iUser;

    @PostMapping("/save")
    public String insertUsers(@RequestBody UserDto user){
            String output = iUser.save(user);
            return output;
    }
    @GetMapping("/login")
    public User login(@RequestParam String userName ,@RequestParam String password){
        User user=iUser.login(userName,password);
        return user;
    }
    @GetMapping("/getById/{userId}")
    public User getById(@PathVariable Integer userId){

        User user=iUser.getByID(userId);

        return user;

    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        List<User> users=iUser.getAll();
        return users;
    }

    @PutMapping("/update")
    public User update(@RequestBody User user,@RequestParam Integer userId){
        User user1 = iUser.update(user,userId);
        return user1;
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer userId){

        try
        {
            String message = iUser.delete(userId);
            return message;

        }catch (RuntimeException e){
            return e.getMessage();
        }
        }

}
