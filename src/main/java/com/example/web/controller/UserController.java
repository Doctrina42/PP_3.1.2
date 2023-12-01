package com.example.web.controller;

import com.example.web.model.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsersList());
        return "users";
    }
    @GetMapping("/new")
    public String getCreateNewUserForm(Model model) {
        model.addAttribute(new User());
        return "new_user";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String removeUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }
}