package com.qalbconnect.qalbconnect.model;

/**
 * Composite Pattern: Leaf
 * Represents a single, simple, indivisible part of a prophet's story.
 * It's a concrete implementation of StoryComponent.
 */
public class SimpleStorySegment implements StoryComponent {
    private final String content;

    public SimpleStorySegment(String content) {
        this.content = content;
    }

    @Override
    public String getNarrative() {
        return content;
    }
}