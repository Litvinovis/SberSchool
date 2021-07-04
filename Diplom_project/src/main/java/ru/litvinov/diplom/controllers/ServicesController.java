package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.diplom.DAO.ServicesDAO;
import ru.litvinov.diplom.models.Master;
import ru.litvinov.diplom.models.Services;


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

    @GetMapping("/admin")
    public String helloPageAdmin(Model model) {
        model.addAttribute("services", ServicesDAO.index());
        return "servicesPage/servicesAdmin";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("serviceNu", ServicesDAO.show(id));
        return "servicesPage/show";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("service", ServicesDAO.show(id));
        return "servicesPage/edit";
    }

    @GetMapping("/{id}/admin")
    public String showAdmin (@PathVariable("id") int id, Model model) {
        model.addAttribute("serviceNu", ServicesDAO.show(id));
        return "servicesPage/showAdmin";
    }

    @GetMapping("/new")
    public String newServices(Model model) {
        model.addAttribute("service", new Services());
        return "servicesPage/new";
    }

    @PostMapping("/admin")
    public String createServices(@ModelAttribute("service") Services services) {
        ServicesDAO.save(services);
        return "redirect:/services/admin";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("master") Services service, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "masterPage/edit";
        ServicesDAO.update(id, service);
        return "redirect:/services/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        ServicesDAO.delete(id);
        return "redirect:/services/admin";
    }
}
