package com.qalbconnect.qalbconnect.tasbeeh.core;

public class UndoCommand implements TasbeehCommand {
    private final TasbeehCounter counter;

    public UndoCommand(TasbeehCounter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.undo();
    }
}