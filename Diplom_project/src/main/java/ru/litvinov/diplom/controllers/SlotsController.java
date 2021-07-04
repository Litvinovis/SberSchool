package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.diplom.DAO.ServicesDAO;
import ru.litvinov.diplom.DAO.SlotsDAO;
import ru.litvinov.diplom.models.Slots;

@Controller
@RequestMapping("/slots")
public class SlotsController{

    private final SlotsDAO slotsDAO;

    @Autowired
    public SlotsController(SlotsDAO slotsDAO) {
        this.slotsDAO = slotsDAO;
    }

    @GetMapping()
    public String helloPage(Model model) {
        return "slotsPage/slots";
    }

    @GetMapping("/admin")
    public String helloPageAdmin(Model model) {
        model.addAttribute("slots", SlotsDAO.index());
        return "slotsPage/slotsAdmin";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("slotsNu", SlotsDAO.show(id));
        return "slotsPage/show";
    }

    @GetMapping("/new")
    public String newServices(Model model) {
        model.addAttribute("slots", new Slots());
        return "slotsPage/new";
    }

    @PostMapping()
    public String createMaster(@ModelAttribute("slots") Slots slots) {
        SlotsDAO.save(slots);
        return "redirect:/slots";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        SlotsDAO.delete(id);
        return "redirect:/slots/admin";
    }
}
