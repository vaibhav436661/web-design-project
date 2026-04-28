package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.entity.Contact;
import com.repository.ContactRepository;

@Controller
public class HomeController {

    @Autowired
    private ContactRepository repo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contact contact) {

        // DEBUG (check console)
        System.out.println("Name: " + contact.getName());
        System.out.println("Phone: " + contact.getPhone());
        System.out.println("Message: " + contact.getMessage());

        repo.save(contact);
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("list", repo.findAll());
        return "admin";
    }
}