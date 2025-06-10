package com.qalbconnect.qalbconnect.versebymood.core;

import java.util.Objects;

public class MoodVerse {
    private final String verse;
    private final String reference;

    public MoodVerse(String verse, String reference) {
        this.verse = verse;
        this.reference = reference;
    }

    public String getVerse() {
        return verse;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodVerse moodVerse = (MoodVerse) o;
        return Objects.equals(verse, moodVerse.verse) &&
               Objects.equals(reference, moodVerse.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verse, reference);
    }

    @Override
    public String toString() {
        return "Verse: " + verse + " (Reference: " + reference + ")";
    }
}