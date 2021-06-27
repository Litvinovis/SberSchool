package ru.litvinov.diplom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.litvinov.diplom.DAO.MasterDAO;
import ru.litvinov.diplom.DAO.ServicesDAO;

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
}