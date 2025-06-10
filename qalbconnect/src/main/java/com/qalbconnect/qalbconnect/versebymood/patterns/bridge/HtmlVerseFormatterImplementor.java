package com.qalbconnect.qalbconnect.versebymood.patterns.bridge;

import org.springframework.stereotype.Component;

@Component("htmlFormatter") // Spring bean name for injection
public class HtmlVerseFormatterImplementor implements VerseFormatterImplementor {
    @Override
    public String formatVerse(String verseText) {
        return "<p class='verse-text'>\"" + verseText + "\"</p>";
    }

    @Override
    public String formatReference(String referenceText) {
        return "<span class='verse-reference'>[" + referenceText + "]</span>";
    }

    @Override
    public String combine(String formattedVerse, String formattedReference) {
        return formattedVerse + "<br>" + formattedReference;
    }
}