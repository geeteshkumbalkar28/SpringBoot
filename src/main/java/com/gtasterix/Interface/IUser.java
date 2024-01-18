package com.gtasterix.Interface;


import com.gtasterix.model.User;

import java.util.List;

public interface IUser {
    User save(User user);

    List<User> displayAll();
}
