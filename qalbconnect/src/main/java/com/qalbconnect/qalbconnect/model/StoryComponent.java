package com.qalbconnect.qalbconnect.model;

/**
 * Composite Pattern: Component Interface
 * Defines the common operations for both simple story segments and composite stories.
 * Clients interact with components uniformly.
 */
public interface StoryComponent {
    String getNarrative();
}