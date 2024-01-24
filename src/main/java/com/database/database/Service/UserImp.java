package com.database.database.Service;

import com.database.database.Interface.IUser;
import com.database.database.Model.User;
import com.database.database.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImp implements IUser {

    @Autowired
    private UserRepo userRepo;
    @Override
    public String save(User user) {
        userRepo.save(user);
        return "user added";
    }

    @Override
    public User getByID(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.get();
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public User update(User user, Integer userId) {
        User user1 = userRepo.findById(userId).orElseThrow(()->new RuntimeException("user not found by id"));



        user1.setFirstName(user.getFirstName());

        user1.setLastName(user.getLastName());

        user1.setMobileNumber(user.getMobileNumber());

        user1.setPassword(user.getPassword());

        userRepo.save(user1);
        return user1;
    }
}
