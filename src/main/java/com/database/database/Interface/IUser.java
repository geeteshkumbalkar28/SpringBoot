package com.database.database.Interface;

import com.database.database.DTO.UserDto;
import com.database.database.Model.User;

import java.util.List;

public interface IUser {
    String save(UserDto user);

    User getByID(Integer userId);

    List<User> getAll();

    User update(User user, Integer userId);

    String delete(Integer userId);
}
