package com.itkrol.KrolSpring.controllers;

import com.itkrol.KrolSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {



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

}
