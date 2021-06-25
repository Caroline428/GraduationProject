package com.itkrol.KrolSpring.controllers;

import com.itkrol.KrolSpring.models.Post;
import com.itkrol.KrolSpring.models.User;
import com.itkrol.KrolSpring.repo.UserRepository;
import com.itkrol.KrolSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;



    @GetMapping("/") //обрабатывает название сайта(ссылку) сейчас это home
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about") //обрабатывает название сайта(ссылку) сейчас это home
    public String about(Model model) {
        model.addAttribute("title", "Страница про нас");
        return "about";
    }

    @GetMapping("/profile/{id}")
    public String profile (@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("title","Профиль");
        if(!userRepository.existsById(id)) {
            return "redirect:/course";
        }
        Optional<User> post = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("user", res);

        return "profile";
    }

    @GetMapping("/profile_admin/{id}")
    public String profileAdmin (@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("title","Профиль");
        if(!userRepository.existsById(id)) {
            return "redirect:/course";
        }
        Optional<User> post = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("user", res);

        return "profile-admin";
    }

    @GetMapping("/users")
    public String courseMain (Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

}
