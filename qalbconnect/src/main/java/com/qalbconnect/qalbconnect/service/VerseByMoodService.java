package com.qalbconnect.qalbconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qalbconnect.qalbconnect.versebymood.VerseByMoodManager;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

@Service
public class VerseByMoodService {

    private final VerseByMoodManager verseByMoodManager;

    @Autowired
    public VerseByMoodService(VerseByMoodManager verseByMoodManager) {
        this.verseByMoodManager = verseByMoodManager;
    }

    public MoodVerse getRandomVerseByMood(String moodInput) {
        return verseByMoodManager.getVerseForInputMood(moodInput);
    }

    public String formatVerseForWeb(MoodVerse verse) {
        // Here we explicitly tell the manager to format as HTML for the web view
        return verseByMoodManager.formatVerseForDisplay(verse, "html");
    }

    public List<String> getAllAvailableMoods() {
        return verseByMoodManager.getAvailableMoodsForDisplay();
    }
}