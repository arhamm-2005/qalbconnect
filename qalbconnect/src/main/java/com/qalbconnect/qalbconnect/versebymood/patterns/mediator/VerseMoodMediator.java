package com.qalbconnect.qalbconnect.versebymood.patterns.mediator;

import java.util.List;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

public interface VerseMoodMediator {
    Mood getValidatedMood(String moodInput);
    MoodVerse getVerseForMood(Mood mood);
    String formatVerse(MoodVerse verse, String formatType);
    List<String> getAvailableMoods();
}