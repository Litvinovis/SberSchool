package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.litvinov.diplom.DAO.ServicesDAO;



@Controller
@RequestMapping("/services")
public class ServicesController{

    private final ServicesDAO servicesDAO;

    @Autowired
    public ServicesController(ServicesDAO servicesDAO) {
        this.servicesDAO = servicesDAO;
    }
    
    @GetMapping()
    public String helloPage(Model model) {
        model.addAttribute("services", ServicesDAO.index());
        return "servicesPage/services";
    }
    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("serviceNu", ServicesDAO.show(id));
        return "servicesPage/show";
    }
}
