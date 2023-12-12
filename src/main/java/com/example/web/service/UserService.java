package com.example.web.service;



import com.example.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);
}