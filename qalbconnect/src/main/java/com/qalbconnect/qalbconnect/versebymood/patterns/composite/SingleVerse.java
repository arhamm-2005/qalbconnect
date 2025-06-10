package com.qalbconnect.qalbconnect.versebymood.patterns.composite;

import java.util.Collections;
import java.util.List;

import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

public class SingleVerse implements VerseCollection {
    private final MoodVerse verse;

    public SingleVerse(MoodVerse verse) {
        this.verse = verse;
    }

    @Override
    public List<MoodVerse> getVerses() {
        return Collections.singletonList(verse);
    }
}