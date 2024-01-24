package com.database.database.Interface;

import com.database.database.Model.User;

import java.util.List;

public interface IUser {
    String save(User user);

    User getByID(Integer userId);

    List<User> getAll();

    User update(User user, Integer userId);
}
