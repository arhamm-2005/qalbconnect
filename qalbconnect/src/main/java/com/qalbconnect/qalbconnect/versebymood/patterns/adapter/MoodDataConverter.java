package com.qalbconnect.qalbconnect.versebymood.patterns.adapter;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;

// Target Interface
public interface MoodDataConverter {
    Mood convertStringToMood(String moodString);
    String convertMoodToString(Mood mood); // Optional, for reverse conversion
}