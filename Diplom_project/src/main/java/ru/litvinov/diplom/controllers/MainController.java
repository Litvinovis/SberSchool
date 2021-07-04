package ru.litvinov.diplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping()
    public String helloPage(Model model) {
        return "mainPage/main";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "mainPage/login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        return "mainPage/mainAdmin";
    }
}