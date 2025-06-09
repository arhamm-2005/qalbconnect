package com.qalbconnect.qalbconnect.tasbeeh.observer;

import java.util.Stack;

public interface TasbeehObserver {
    void update(int currentCount, Stack<Integer> history);
}