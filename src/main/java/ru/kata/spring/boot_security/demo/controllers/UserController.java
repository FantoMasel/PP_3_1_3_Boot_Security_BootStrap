package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUser(Principal principal, Model model) {
        String userName = principal.getName();
        User user = userService.getUserByUsername(userName);
        model.addAttribute("user", user);
        return "/user";
    }

    @GetMapping("/adminuser")
    public String showAdminUser(Principal principal, Model model) {
        String userName = principal.getName();
        User user = userService.getUserByUsername(userName);
        model.addAttribute("user", user);
        return "/adminuser";
    }


}
