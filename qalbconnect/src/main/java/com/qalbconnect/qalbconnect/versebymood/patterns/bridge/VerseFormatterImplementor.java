package com.qalbconnect.qalbconnect.versebymood.patterns.bridge;
public interface VerseFormatterImplementor {
    String formatVerse(String verseText);
    String formatReference(String referenceText);
    String combine(String formattedVerse, String formattedReference);
}