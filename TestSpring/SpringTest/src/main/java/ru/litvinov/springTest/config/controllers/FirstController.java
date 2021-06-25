package ru.litvinov.springTest.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage() {
//        return "first/hello";
//    }
//
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        model.addAttribute("message", "hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/bye")
    public String byePage() {
        return "first/bye";
    }

    @GetMapping("/exit")
    public String exitPage() {
        return "first/exit";
    }
}
