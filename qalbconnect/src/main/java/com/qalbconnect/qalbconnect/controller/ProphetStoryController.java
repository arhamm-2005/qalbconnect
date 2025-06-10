package com.qalbconnect.qalbconnect.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.qalbconnect.qalbconnect.model.ProphetStory;
import com.qalbconnect.qalbconnect.service.ProphetStoryService;

/**
 * Controller Layer: Handles web requests for Prophet Stories.
 * It's part of the Model-View-Controller (MVC) architectural pattern.
 * It interacts with the ProphetStoryService to retrieve data.
 */
@Controller
public class ProphetStoryController {

    private final ProphetStoryService prophetStoryService;

    public ProphetStoryController(ProphetStoryService prophetStoryService) {
        this.prophetStoryService = prophetStoryService;
    }

    /**
     * Displays a list of all prophets.
     * Accessible at: /prophets
     * @param model The Spring Model to pass data to the view.
     * @return The name of the Thymeleaf template for listing prophets.
     */
    @GetMapping("/prophets")
    public String listProphets(Model model) {
        List<String> prophetNames = prophetStoryService.getAllProphetNames();
        model.addAttribute("prophetNames", prophetNames);
        return "prophet-stories-list"; // Thymeleaf template name
    }

    /**
     * Displays a specific prophet's story based on a request parameter.
     * Accessible at: /prophets/story?name=Hazrat Adam (A.S)
     * @param name The name of the Prophet from the request parameter.
     * @param model The Spring Model to pass data to the view.
     * @return The name of the Thymeleaf template for displaying a single story or redirecting with an error.
     */
    @GetMapping("/prophets/story")
    public String getProphetStory(@RequestParam("name") String name, Model model) {
        Optional<ProphetStory> story = prophetStoryService.getProphetStory(name);
        if (story.isPresent()) {
            model.addAttribute("prophetStory", story.get());
            return "prophet-story-detail"; // Thymeleaf template for single story
        } else {
            model.addAttribute("errorMessage", "Story not found for Prophet: '" + name + "'. Please check the name.");
            // If story not found, redirect back to the list with an error message
            List<String> prophetNames = prophetStoryService.getAllProphetNames();
            model.addAttribute("prophetNames", prophetNames);
            return "prophet-stories-list";
        }
    }

    /**
     * Optional: Displays a specific prophet's story based on a path variable.
     * Accessible at: /prophets/story/Hazrat%20Adam%20(A.S)
     * This method reuses the logic from the @RequestParam method.
     * @param name The name of the Prophet from the path variable.
     * @param model The Spring Model to pass data to the view.
     * @return The name of the Thymeleaf template for displaying a single story or redirecting with an error.
     */
    @GetMapping("/prophets/story/{name}")
    public String getProphetStoryByPath(@PathVariable("name") String name, Model model) {
        // Reuse the logic from the @RequestParam method for consistency
        return getProphetStory(name, model);
    }
}