package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.diplom.DAO.MasterDAO;
import ru.litvinov.diplom.DAO.ServicesDAO;
import ru.litvinov.diplom.models.Master;

@Controller
@RequestMapping("/masters")
public class MasterController {

    private final MasterDAO masterDAO;

    @Autowired
    public MasterController(MasterDAO masterDAO) {
        this.masterDAO = masterDAO;
    }

    @GetMapping()
    public String helloPage(Model model) {
        model.addAttribute("masters", MasterDAO.index());
        return "masterPage/masters";
    }

    @GetMapping("/admin")
    public String helloPageAdmin(Model model) {
        model.addAttribute("masters", MasterDAO.index());
        return "masterPage/mastersAdmin";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("master", MasterDAO.show(id));
        return "masterPage/show";
    }

    @GetMapping("/{id}/admin")
    public String showAdmin (@PathVariable("id") int id, Model model) {
        model.addAttribute("master", MasterDAO.show(id));
        return "masterPage/showAdmin";
    }


    @GetMapping("/new")
    public String newMaster(Model model) {
        model.addAttribute("master", new Master());
        return "masterPage/new";
    }

    @PostMapping("/admin")
    public String createMaster(@ModelAttribute("master") Master master) {
        masterDAO.save(master);
        return "redirect:/masters/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("master", masterDAO.show(id));
        return "masterPage/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("master") Master master, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "masterPage/edit";
        masterDAO.update(id, master);
        return "redirect:/masters/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        masterDAO.delete(id);
        return "redirect:/masters/admin";
    }
}