package com.qalbconnect.qalbconnect.tasbeeh.core;

public class IncrementCommand implements TasbeehCommand {
    private final TasbeehCounter counter; // The receiver of the command

    public IncrementCommand(TasbeehCounter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.increment();
    }
}