package com.itkrol.KrolSpring.controllers;

import com.itkrol.KrolSpring.models.User;
import com.itkrol.KrolSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, @RequestParam String nam,
                          @RequestParam String sec, @RequestParam String email, @RequestParam Integer age, Model model ) {
        User userForm = new User();
        userForm.setUsername(username);
        userForm.setPassword(password);
        userForm.setFirstname(nam);
        userForm.setSecondname(sec);
        userForm.setEmail(email);
        userForm.setAge(age);
        userService.saveUser(userForm);
        return "redirect:/course";

    }
}
