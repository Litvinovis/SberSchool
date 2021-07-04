package ru.litvinov.diplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping()
    public String helloPage(Model model) {
        return "mainPage/contacts";
    }

    @GetMapping("/admin")
    public String helloPageAdmin(Model model) {
        return "mainPage/contactsAdmin";
    }
}