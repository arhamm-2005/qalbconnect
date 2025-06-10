package com.qalbconnect.qalbconnect.versebymood.patterns.chainofresponsibility;

import com.qalbconnect.qalbconnect.versebymood.core.Mood;

public abstract class MoodValidator {
    protected MoodValidator nextValidator;

    public void setNextValidator(MoodValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract Mood validateMood(String moodInput);
}