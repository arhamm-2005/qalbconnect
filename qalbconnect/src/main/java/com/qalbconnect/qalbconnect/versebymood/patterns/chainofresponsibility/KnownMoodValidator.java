package com.qalbconnect.qalbconnect.versebymood.patterns.chainofresponsibility;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;
import com.qalbconnect.qalbconnect.versebymood.data.VerseDataLoader;
import com.qalbconnect.qalbconnect.versebymood.patterns.adapter.MoodDataConverter;

@Component
public class KnownMoodValidator extends MoodValidator {

    private final MoodDataConverter moodDataConverter;
    private final Set<String> knownMoodStrings;

    public KnownMoodValidator(MoodDataConverter moodDataConverter, VerseDataLoader dataLoader) {
        this.moodDataConverter = moodDataConverter;
        this.knownMoodStrings = dataLoader.getMoodVersesData().keySet().stream()
                                .map(Mood::name)
                                .collect(Collectors.toSet());
    }

    @Override
    public Mood validateMood(String moodInput) {
        if (moodInput != null && knownMoodStrings.contains(moodInput.toUpperCase())) {
            return moodDataConverter.convertStringToMood(moodInput);
        } else if (nextValidator != null) {
            return nextValidator.validateMood(moodInput);
        }
        return Mood.UNKNOWN;
    }
}