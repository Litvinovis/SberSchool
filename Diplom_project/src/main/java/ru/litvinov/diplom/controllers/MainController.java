package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import ru.litvinov.diplom.DAO.ServicesDAO;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main")
public class MainController {

    private final ServicesDAO servicesDAO;

    @Autowired
    public MainController(ServicesDAO servicesDAO) {
        this.servicesDAO = servicesDAO;
    }

    @GetMapping()
    public String helloPage(Model model) {
        model.addAttribute("services", ServicesDAO.index());
        return "mainPage/main";
    }
    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        return null;
    }
}