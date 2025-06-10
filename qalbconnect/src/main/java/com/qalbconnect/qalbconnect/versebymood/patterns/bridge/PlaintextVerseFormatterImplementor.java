package com.qalbconnect.qalbconnect.versebymood.patterns.bridge;

import org.springframework.stereotype.Component;

@Component("plaintextFormatter") // Spring bean name for injection
public class PlaintextVerseFormatterImplementor implements VerseFormatterImplementor {
    @Override
    public String formatVerse(String verseText) {
        return "Verse: " + verseText;
    }

    @Override
    public String formatReference(String referenceText) {
        return "Reference: " + referenceText;
    }

    @Override
    public String combine(String formattedVerse, String formattedReference) {
        return formattedVerse + " (" + formattedReference + ")";
    }
}