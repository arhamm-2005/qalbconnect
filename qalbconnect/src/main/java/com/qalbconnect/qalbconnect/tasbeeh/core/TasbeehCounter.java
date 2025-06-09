package com.qalbconnect.qalbconnect.tasbeeh.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.qalbconnect.qalbconnect.tasbeeh.observer.TasbeehObserver;

public class TasbeehCounter {

    private int currentCount = 0;
    private final Stack<Integer> countHistory = new Stack<>();
    private final List<TasbeehObserver> observers = new ArrayList<>();

    // --- Observer Pattern Implementation ---
    public void addObserver(TasbeehObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(TasbeehObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        // Pass a copy of history to prevent external modification by observers
        Stack<Integer> historyCopy = new Stack<>();
        historyCopy.addAll(countHistory);
        for (TasbeehObserver observer : observers) {
            observer.update(currentCount, historyCopy);
        }
    }

    // --- Core Counter Logic (actions that notify observers) ---
    public void increment() {
        countHistory.push(currentCount); // Save state before change
        currentCount++;
        notifyObservers(); // Notify after state change
    }

    public void reset() {
        countHistory.push(currentCount); // Save state before change
        currentCount = 0;
        notifyObservers(); // Notify after state change
    }

    public void undo() {
        if (!countHistory.isEmpty()) {
            currentCount = countHistory.pop();
            notifyObservers(); // Notify after state change
        } else {
            // In a web app, you might return a specific status or throw an exception,
            // but for simple logging, System.out is fine for now.
            System.out.println("TasbeehCounter: No actions to undo.");
        }
    }

    // --- Getters for current state ---
    public int getCurrentCount() {
        return currentCount;
    }

    public Stack<Integer> getCountHistory() {
        Stack<Integer> copy = new Stack<>();
        copy.addAll(countHistory);
        return copy; // Return a copy
    }
}