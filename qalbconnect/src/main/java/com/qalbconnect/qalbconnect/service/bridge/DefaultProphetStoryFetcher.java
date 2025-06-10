package com.qalbconnect.qalbconnect.service.bridge;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.model.ProphetStory;
import com.qalbconnect.qalbconnect.service.adapter.ProphetStorySource;
import com.qalbconnect.qalbconnect.service.factory.ProphetStorySourceFactory;

/**
 * Bridge Pattern: Concrete Abstraction
 * This class implements the Abstraction interface (ProphetStoryFetcher)
 * and holds a reference to the Implementor (ProphetStorySource).
 * It effectively bridges the high-level fetching operations with the low-level data source.
 */
@Component
public class DefaultProphetStoryFetcher implements ProphetStoryFetcher {

    private final ProphetStorySource storySource; // This is the Implementor part of the Bridge

    public DefaultProphetStoryFetcher(ProphetStorySourceFactory storySourceFactory) {
        // The Implementor (ProphetStorySource) is obtained from the Factory
        this.storySource = storySourceFactory.getStorySource();
    }

    @Override
    public Optional<ProphetStory> fetchStoryByName(String name) {
        return storySource.getStoryByName(name);
    }

    @Override
    public List<String> fetchAllProphetNames() {
        return storySource.getAllProphetNames();
    }
}