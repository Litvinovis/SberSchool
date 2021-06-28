package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model) {
        model.addAttribute("master", MasterDAO.show(id));
        return "masterPage/show";
    }

    @GetMapping("/new")
    public String newMaster(Model model) {
        model.addAttribute("master", new Master());
        return "masterPage/new";
    }

    @PostMapping()
    public String createMaster(@ModelAttribute("master") Master master) {
        masterDAO.save(master);
        return "redirect:/masters";
    }
}