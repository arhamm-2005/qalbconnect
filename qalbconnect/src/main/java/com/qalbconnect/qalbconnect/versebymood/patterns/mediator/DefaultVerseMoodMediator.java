package com.qalbconnect.qalbconnect.versebymood.patterns.mediator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;
import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;
import com.qalbconnect.qalbconnect.versebymood.data.VerseDataLoader;
import com.qalbconnect.qalbconnect.versebymood.patterns.bridge.SimpleVerseFormatter;
import com.qalbconnect.qalbconnect.versebymood.patterns.bridge.VerseFormatterImplementor;
import com.qalbconnect.qalbconnect.versebymood.patterns.chainofresponsibility.MoodValidator;
import com.qalbconnect.qalbconnect.versebymood.patterns.factory.VerseFormatterFactory;

@Component
public class DefaultVerseMoodMediator implements VerseMoodMediator {

    private final MoodValidator moodValidatorChain; // Chain of Responsibility
    private final VerseDataLoader verseDataLoader; // Data source
    private final VerseFormatterFactory formatterFactory; // Factory for formatters
    private final Random random = new Random();

    public DefaultVerseMoodMediator(
            @Qualifier("knownMoodValidator") MoodValidator knownMoodValidator,
            @Qualifier("fallbackMoodValidator") MoodValidator fallbackMoodValidator,
            VerseDataLoader verseDataLoader,
            VerseFormatterFactory formatterFactory) {

        // Build the Chain of Responsibility
        knownMoodValidator.setNextValidator(fallbackMoodValidator);
        this.moodValidatorChain = knownMoodValidator;

        this.verseDataLoader = verseDataLoader;
        this.formatterFactory = formatterFactory;
    }

    @Override
    public Mood getValidatedMood(String moodInput) {
        return moodValidatorChain.validateMood(moodInput);
    }

    @Override
    public MoodVerse getVerseForMood(Mood mood) {
        List<MoodVerse> verses = verseDataLoader.getMoodVersesData().get(mood);
        if (verses != null && !verses.isEmpty()) {
            return verses.get(random.nextInt(verses.size()));
        }
        return null;
    }

    @Override
    public String formatVerse(MoodVerse verse, String formatType) {
        if (verse == null) {
            return "No verse to format.";
        }
        VerseFormatterImplementor implementor = formatterFactory.getFormatterImplementor(formatType);
        SimpleVerseFormatter formatter = new SimpleVerseFormatter(implementor);
        return formatter.format(verse);
    }

    @Override
    public List<String> getAvailableMoods() {
        return verseDataLoader.getMoodVersesData().keySet().stream()
                .filter(mood -> mood != Mood.UNKNOWN)
                .map(Mood::name)
                .collect(Collectors.toList());
    }
}