package com.qalbconnect.qalbconnect.versebymood.patterns.chainofresponsibility;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;

@Component
public class FallbackMoodValidator extends MoodValidator {
    @Override
    public Mood validateMood(String moodInput) {
        // This is the last handler in the chain.
        // If the mood is not recognized by previous handlers, it defaults to UNKNOWN.
        System.out.println("FallbackMoodValidator: Mood '" + moodInput + "' not recognized. Returning UNKNOWN.");
        return Mood.UNKNOWN;
    }
}