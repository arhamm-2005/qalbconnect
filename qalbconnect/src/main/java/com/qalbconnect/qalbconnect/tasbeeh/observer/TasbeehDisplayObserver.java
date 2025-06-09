package com.qalbconnect.qalbconnect.tasbeeh.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // This ensures one instance per user session, holding session-specific display data
public class TasbeehDisplayObserver implements TasbeehObserver {

    private int currentCountForDisplay;
    private List<Integer> historyForDisplay;

    public TasbeehDisplayObserver() {
        this.currentCountForDisplay = 0;
        this.historyForDisplay = new ArrayList<>();
    }

    @Override
    public void update(int currentCount, Stack<Integer> history) {
        this.currentCountForDisplay = currentCount;
        // Create an immutable list from the history stack for display
        this.historyForDisplay = Collections.unmodifiableList(new ArrayList<>(history));
        // Optional: log to console for debugging
        System.out.println("TasbeehDisplayObserver: State Updated - Count: " + currentCount + ", History size: " + history.size());
    }

    public int getCurrentCountForDisplay() {
        return currentCountForDisplay;
    }

    public List<Integer> getHistoryForDisplay() {
        return historyForDisplay;
    }
}