package com.qalbconnect.qalbconnect.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qalbconnect.qalbconnect.service.TasbeehService;

@Controller
@RequestMapping("/tasbeehcounter")
public class TasbeehController {

    private final TasbeehService tasbeehService; // Spring injects the session-scoped TasbeehService

    public TasbeehController(TasbeehService tasbeehService) {
        this.tasbeehService = tasbeehService;
    }

    @GetMapping // Handles GET requests to /tasbeeh
    public String showTasbeehCounter(Model model) {
        model.addAttribute("currentCount", tasbeehService.getCurrentCountForDisplay());
        
        // Format history for display in Thymeleaf
        List<Integer> history = tasbeehService.getHistoryForDisplay();
        String formattedHistory = history.isEmpty() ? "No history" : history.toString().replace("[", "").replace("]", "");
        model.addAttribute("history", formattedHistory);
        
        return "tasbeeh"; // Renders src/main/resources/templates/tasbeeh.html
    }

    @PostMapping("/increment") // Handles POST requests to /tasbeeh/increment
    public String incrementCount() {
        tasbeehService.increment();
        return "redirect:/tasbeehcounter"; // Redirects back to the /tasbeeh GET endpoint to refresh the page
    }

    @PostMapping("/reset") // Handles POST requests to /tasbeeh/reset
    public String resetCount() {
        tasbeehService.reset();
        return "redirect:/tasbeehcounter";
    }

    @PostMapping("/undo") // Handles POST requests to /tasbeeh/undo
    public String undoCount() {
        tasbeehService.undo();
        return "redirect:/tasbeehcounter";
    }
}