package com.itkrol.KrolSpring.controllers;

import com.itkrol.KrolSpring.models.User;
import com.itkrol.KrolSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

//    @GetMapping("/registration")
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "registration.html";
//    }
//
//    @PostMapping("/registration")
//    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
//                          BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "registration.html";
//        }
//        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
//            model.addAttribute("passwordError", "Пароли не совпадают");
//            return "registration.html";
//        }
//        if (!userService.saveUser(userForm)) {
//            model.addAttribute("usernameError","Пользователь с таким именем уже существует");
//            return "registration.html";
//
//        }
//        return "redirect:/";
//    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration.html";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam String username, @RequestParam String password, Model model ) {
        User userForm = new User();
        userForm.setUsername(username);
        userForm.setPassword(password);
        userService.saveUser(userForm);
        return "redirect:/blog";

    }
}
