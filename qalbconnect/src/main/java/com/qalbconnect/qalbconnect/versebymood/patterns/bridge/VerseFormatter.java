package com.qalbconnect.qalbconnect.versebymood.patterns.bridge;

import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

// Abstraction (Defines the high-level control logic)
public abstract class VerseFormatter {
    protected VerseFormatterImplementor implementor; // Bridge to the implementor

    public VerseFormatter(VerseFormatterImplementor implementor) {
        this.implementor = implementor;
    }

    public abstract String format(MoodVerse verse);
}