package com.example.web.dao;


import com.example.web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}