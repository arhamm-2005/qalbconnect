package com.qalbconnect.qalbconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.qalbconnect.qalbconnect.tasbeeh.core.IncrementCommand;
import com.qalbconnect.qalbconnect.tasbeeh.core.ResetCommand;
import com.qalbconnect.qalbconnect.tasbeeh.core.TasbeehCounter;
import com.qalbconnect.qalbconnect.tasbeeh.core.UndoCommand;
import com.qalbconnect.qalbconnect.tasbeeh.observer.TasbeehDisplayObserver;

import jakarta.annotation.PostConstruct; // For initialization lifecycle method

@Service
@SessionScope // Crucial: Ensures a new TasbeehService instance (and its TasbeehCounter) for each user session
public class TasbeehService {

    private final TasbeehCounter tasbeehCounter; // Core counter logic, specific to this session
    private final TasbeehDisplayObserver displayObserver; // Observer to hold display data, also session-scoped

    public TasbeehService(TasbeehDisplayObserver displayObserver) {
        this.tasbeehCounter = new TasbeehCounter(); // Initialize a new TasbeehCounter for this session
        this.displayObserver = displayObserver;
    }

    @PostConstruct // This method runs after the TasbeehService bean has been created and its dependencies injected
    public void setupCounter() {
        // Attach the session-scoped display observer to this session's tasbeehCounter
        tasbeehCounter.addObserver(displayObserver);
        // Perform an initial update so the display observer has the starting state (0, empty history)
        displayObserver.update(tasbeehCounter.getCurrentCount(), tasbeehCounter.getCountHistory());
    }

    // --- Public methods for controller to call (executing commands) ---
    public void increment() {
        // Create an IncrementCommand and execute it.
        // The command will call tasbeehCounter.increment(), which in turn notifies the observer.
        new IncrementCommand(tasbeehCounter).execute();
    }

    public void reset() {
        new ResetCommand(tasbeehCounter).execute();
    }

    public void undo() {
        new UndoCommand(tasbeehCounter).execute();
    }

    // --- Methods to retrieve current state for UI (from the observer) ---
    public int getCurrentCountForDisplay() {
        return displayObserver.getCurrentCountForDisplay();
    }

    public List<Integer> getHistoryForDisplay() {
        return displayObserver.getHistoryForDisplay();
    }
}