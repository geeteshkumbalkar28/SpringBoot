package com.gtasterix;

import org.springframework.web.bind.annotation.*;

@RestController
public class controller {
    @GetMapping("/get")
    public String get(){
        return "Hello !!";
    }
    @GetMapping("/getOne")
    public String getOne(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String mobileNumber){
        return firstName + lastName + mobileNumber;
    }

    @GetMapping("/getTwo/{firstName}/{lastName}/{mobileNumber}")
    public String getTwo(@PathVariable String firstName,@PathVariable String lastName,@PathVariable String mobileNumber ){
        return firstName + lastName + mobileNumber;
    }

    @GetMapping("/getThree")
    public User getThree(@RequestBody User user){

        System.out.println(user);
        return user;
    }

}
