package com.qalbconnect.qalbconnect.versebymood.patterns.factory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.patterns.bridge.VerseFormatterImplementor;

@Component
public class VerseFormatterFactory {

    private final VerseFormatterImplementor plaintextFormatter;
    private final VerseFormatterImplementor htmlFormatter;

    public VerseFormatterFactory(
            @Qualifier("plaintextFormatter") VerseFormatterImplementor plaintextFormatter,
            @Qualifier("htmlFormatter") VerseFormatterImplementor htmlFormatter) {
        this.plaintextFormatter = plaintextFormatter;
        this.htmlFormatter = htmlFormatter;
    }

    public VerseFormatterImplementor getFormatterImplementor(String formatType) {
        if ("html".equalsIgnoreCase(formatType)) {
            return htmlFormatter;
        } else {
            return plaintextFormatter; // Default to plaintext
        }
    }
}