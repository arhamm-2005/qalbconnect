package com.qalbconnect.qalbconnect.tasbeeh.core;

public class ResetCommand implements TasbeehCommand {
    private final TasbeehCounter counter;

    public ResetCommand(TasbeehCounter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.reset();
    }
}