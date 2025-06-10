package com.qalbconnect.qalbconnect.service.bridge;

import java.util.List;
import java.util.Optional;

import com.qalbconnect.qalbconnect.model.ProphetStory;

/**
 * Bridge Pattern: Abstraction Interface
 * Defines the high-level operations for fetching prophet stories.
 * This interface is used by the ProphetStoryService, decoupling it from the
 * actual data source implementation (the Implementor part of the Bridge).
 */
public interface ProphetStoryFetcher {
    Optional<ProphetStory> fetchStoryByName(String name);
    List<String> fetchAllProphetNames();
}