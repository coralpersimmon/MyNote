package com.mynote.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // login.html
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // notes.html
    @GetMapping("/notes")
    public String showNotesPage(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        return "notes";
    }
}
