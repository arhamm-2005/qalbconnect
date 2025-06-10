package com.qalbconnect.qalbconnect.versebymood.patterns.adapter;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;

@Component
public class SimpleMoodDataConverter implements MoodDataConverter {

    @Override
    public Mood convertStringToMood(String moodString) {
        try {
            return Mood.valueOf(moodString.toUpperCase());
        } catch (IllegalArgumentException e) {
            // If the string doesn't match any enum constant, return UNKNOWN or handle
            return Mood.UNKNOWN;
        }
    }

    @Override
    public String convertMoodToString(Mood mood) {
        return mood.name();
    }
}