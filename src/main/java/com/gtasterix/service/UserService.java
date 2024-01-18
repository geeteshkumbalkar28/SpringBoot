package com.gtasterix.service;


import com.gtasterix.Interface.IUser;
import com.gtasterix.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService implements IUser {

    private List<User> users = new LinkedList<>();
    @Override
    public User save(User user) {
        if (user.getFirstName().equals(null) || user.getLastName().equals(null)){return null;}

        users.add(user);
        return user;
    }

    @Override
    public List<User> displayAll() {
        return users;
    }


}
