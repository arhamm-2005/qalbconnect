package com.qalbconnect.qalbconnect.versebymood.patterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.qalbconnect.qalbconnect.versebymood.core.MoodVerse;

public class MoodVerseGroup implements VerseCollection {
    private final List<VerseCollection> children = new ArrayList<>();
    private final String groupName;

    public MoodVerseGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(VerseCollection collection) {
        children.add(collection);
    }

    public void remove(VerseCollection collection) {
        children.remove(collection);
    }

    @Override
    public List<MoodVerse> getVerses() {
        List<MoodVerse> allVerses = new ArrayList<>();
        for (VerseCollection child : children) {
            allVerses.addAll(child.getVerses());
        }
        return Collections.unmodifiableList(allVerses);
    }

    public String getGroupName() {
        return groupName;
    }
}