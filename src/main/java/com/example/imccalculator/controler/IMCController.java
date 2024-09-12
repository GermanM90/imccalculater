package com.example.imccalculator.controler;

import com.example.imccalculator.model.Person;
import com.example.imccalculator.service.IMCservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IMCController {

    private final IMCservice imcService;

    public IMCController(IMCservice imcService) {
        this.imcService = imcService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateIMC(@ModelAttribute Person person, Model model) {
        double imc = imcService.calculateIMC(person);
        model.addAttribute("imc", imc);
        return "result";
    }
}

