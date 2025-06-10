package com.qalbconnect.qalbconnect.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Composite Pattern: Composite
 * Represents a full prophet's story, composed of multiple StoryComponent (segments).
 * It manages child components and provides a unified interface.
 *
 * Builder Pattern: Product
 * This is the complex object that ProphetStory.Builder builds.
 */
public class ProphetStory implements StoryComponent {
    private String name;
    private final List<StoryComponent> segments; // List of segments for Composite Pattern

    // Private constructor to enforce object creation through the Builder
    private ProphetStory(String name, List<StoryComponent> segments) {
        this.name = name;
        this.segments = new ArrayList<>(segments); // Defensive copy for immutability
    }

    @Override
    public String getNarrative() {
        StringBuilder fullStory = new StringBuilder();
        for (StoryComponent segment : segments) {
            fullStory.append(segment.getNarrative()).append("\n\n"); // Add newlines for readability
        }
        return fullStory.toString().trim(); // Remove trailing newlines
    }

    public String getName() {
        return name;
    }

    // You might choose to make name immutable and only set in builder if desired
    public void setName(String name) {
        this.name = name;
    }

    public List<StoryComponent> getSegments() {
        return new ArrayList<>(segments); // Return a defensive copy
    }

    /**
     * Builder Pattern: Builder
     * Provides a fluent API for constructing complex ProphetStory objects step-by-step.
     * This is especially useful as ProphetStory now has multiple segments (Composite).
     */
    public static class Builder {
        private String name;
        private final List<StoryComponent> segments = new ArrayList<>();

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder addSegment(String content) {
            this.segments.add(new SimpleStorySegment(content));
            return this;
        }

        // Optional: Method to add another composite story as a segment (for deeper hierarchies)
        public Builder addStory(ProphetStory compositeStory) {
            this.segments.add(compositeStory);
            return this;
        }

        public ProphetStory build() {
            Objects.requireNonNull(name, "Prophet name must not be null.");
            if (segments.isEmpty()) {
                throw new IllegalStateException("Prophet story must have at least one segment.");
            }
            return new ProphetStory(name, segments);
        }
    }
}