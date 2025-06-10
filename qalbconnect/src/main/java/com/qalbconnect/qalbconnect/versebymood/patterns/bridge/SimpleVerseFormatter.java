package com.qalbconnect.qalbconnect.versebymood.patterns.bridge;

import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

// Concrete Abstraction (Client-facing)
public class SimpleVerseFormatter extends VerseFormatter {

    public SimpleVerseFormatter(VerseFormatterImplementor implementor) {
        super(implementor);
    }

    @Override
    public String format(MoodVerse verse) {
        String formattedVerse = implementor.formatVerse(verse.getVerse());
        String formattedReference = implementor.formatReference(verse.getReference());
        return implementor.combine(formattedVerse, formattedReference);
    }
}