package com.qalbconnect.qalbconnect.service.factory;

import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.service.adapter.InMemoryProphetStorySource;
import com.qalbconnect.qalbconnect.service.adapter.ProphetStorySource;

/**
 * Factory Pattern: Factory
 * Provides a method to create and provide instances of ProphetStorySource.
 * It centralizes the logic for choosing which concrete data source implementation to use,
 * effectively decoupling the client (ProphetStoryFetcher) from the instantiation process.
 */
@Component
public class ProphetStorySourceFactory {

    private final InMemoryProphetStorySource inMemorySource; // Injected as an example source

    public ProphetStorySourceFactory(InMemoryProphetStorySource inMemorySource) {
        this.inMemorySource = inMemorySource;
    }

    /**
     * Returns a ProphetStorySource instance.
     * In a real application, this could be based on configuration (e.g., "db", "json", "api")
     * or environment variables to provide different ProphetStorySource implementations.
     * For this example, it always returns the in-memory source.
     * @return a ProphetStorySource implementation.
     */
    public ProphetStorySource getStorySource() {
        // Example: If a configuration property 'app.story.source' was set to 'database',
        // you would return a DatabaseProphetStorySource instance here.
        // For now, we'll return the in-memory one as it's the only one implemented.
        return inMemorySource;
    }
}