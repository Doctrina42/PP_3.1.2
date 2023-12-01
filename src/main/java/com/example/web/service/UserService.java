package com.example.web.service;



import com.example.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersList();
    User getUser(int id);
    void addUser(User user);
    void deleteUser(int id);
    void editUser(User user);
}