package com.qalbconnect.qalbconnect.versebymood;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;
import com.qalbconnect.qalbconnect.versebymood.patterns.mediator.VerseMoodMediator;

@Service // Making it a Spring Service bean
public class VerseByMoodManager {

    private final VerseMoodMediator mediator; // Inject the Mediator

    @Autowired
    public VerseByMoodManager(VerseMoodMediator mediator) {
        this.mediator = mediator;
    }

    public MoodVerse getVerseForInputMood(String moodInput) { // Removed formatType here, service will decide
        // Use Mediator to validate mood
        Mood validatedMood = mediator.getValidatedMood(moodInput);

        if (validatedMood == Mood.UNKNOWN) {
            return new MoodVerse("No verses found for '" + moodInput + "'. Please try a known mood.", "N/A");
        }

        // Use Mediator to get the verse for the validated mood
        return mediator.getVerseForMood(validatedMood);
    }

    public String formatVerseForDisplay(MoodVerse verse, String formatType) {
        return mediator.formatVerse(verse, formatType);
    }

    public List<String> getAvailableMoodsForDisplay() {
        return mediator.getAvailableMoods();
    }
}