package com.qalbconnect.qalbconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qalbconnect.qalbconnect.service.VerseByMoodService;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

@Controller
@RequestMapping("/versebymood") // Controller's base URL
public class VerseByMoodController {

    private final VerseByMoodService verseByMoodService;

    @Autowired
    public VerseByMoodController(VerseByMoodService verseByMoodService) {
        this.verseByMoodService = verseByMoodService;
    }

    @GetMapping
    public String showVerseByMoodPage(Model model) {
        List<String> availableMoods = verseByMoodService.getAllAvailableMoods();
        model.addAttribute("moods", availableMoods);
        // Initialize with empty or default values
        model.addAttribute("selectedMood", "");
        model.addAttribute("verseText", "Select a mood to get a verse."); // Default text
        model.addAttribute("verseReference", ""); // Default text
        model.addAttribute("message", "Please choose your current mood:"); // Initial message
        return "versebymood"; // Renders src/main/resources/templates/versebymood.html
    }

    @PostMapping("/getVerse")
    public String getVerseForMood(@RequestParam("mood") String mood, Model model) {
        MoodVerse moodVerse = verseByMoodService.getRandomVerseByMood(mood);

        List<String> availableMoods = verseByMoodService.getAllAvailableMoods();
        model.addAttribute("moods", availableMoods);
        model.addAttribute("selectedMood", mood); // Keep the selected mood in the dropdown

        if (moodVerse != null && !"N/A".equals(moodVerse.getReference())) { // Check if it's a valid verse
            // Using the service to format for web, leveraging the Bridge pattern
            model.addAttribute("verseTextFormatted", verseByMoodService.formatVerseForWeb(moodVerse));
            // You can also pass raw verse/reference if you want Thymeleaf to do formatting or for fallback
            model.addAttribute("verseText", moodVerse.getVerse());
            model.addAttribute("verseReference", moodVerse.getReference());
            model.addAttribute("message", "Here is a verse for your mood:");
        } else {
            // Handle case where no valid verse was found (e.g., "UNKNOWN" mood)
            model.addAttribute("verseText", moodVerse.getVerse()); // Display the message from MoodVerse
            model.addAttribute("verseReference", moodVerse.getReference()); // Display N/A or empty
            model.addAttribute("message", "Sorry, no verses found for that mood or mood is invalid.");
        }
        return "versebymood"; // Renders the same page with updated data
    }
}