package com.qalbconnect.qalbconnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qalbconnect.qalbconnect.model.ProphetStory;
import com.qalbconnect.qalbconnect.service.bridge.ProphetStoryFetcher;
import com.qalbconnect.qalbconnect.service.chain.ProphetNameHandler;
import com.qalbconnect.qalbconnect.service.chain.ProphetNameNormalizationHandler;
import com.qalbconnect.qalbconnect.service.chain.ProphetNameValidationHandler;
import com.qalbconnect.qalbconnect.service.mediator.ProphetStoryEventMediator;

/**
 * Service Layer: Contains the core business logic for retrieving prophet stories.
 * It acts as a client for Bridge, Chain of Responsibility, and Mediator patterns.
 */
@Service
public class ProphetStoryService {

    private final ProphetStoryFetcher prophetStoryFetcher; // Client for Bridge Pattern
    private final ProphetNameHandler prophetNameChain; // Entry point for Chain of Responsibility
    private final ProphetStoryEventMediator mediator; // Client for Mediator Pattern

    public ProphetStoryService(ProphetStoryFetcher prophetStoryFetcher,
                               ProphetNameNormalizationHandler normalizationHandler,
                               ProphetNameValidationHandler validationHandler,
                               ProphetStoryEventMediator mediator) {
        this.prophetStoryFetcher = prophetStoryFetcher;
        this.mediator = mediator;

        // Chain of Responsibility: Set up the chain
        // Requests will flow from Normalization -> Validation
        normalizationHandler.setNextHandler(validationHandler);
        // The validationHandler (last in this simple chain) doesn't have a next handler set,
        // so it implicitly terminates the chain by calling super.callNextHandler(prophetName) which returns the name.
        this.prophetNameChain = normalizationHandler; // The chain starts with normalization
    }

    /**
     * Retrieves a prophet's story by name.
     * - Uses Chain of Responsibility for processing the prophet name (normalization, validation).
     * - Uses Bridge pattern (via ProphetStoryFetcher) for decoupled data fetching.
     * - Notifies Mediator for events (story viewed/not found).
     * @param name The name of the prophet.
     * @return An Optional containing the ProphetStory if found.
     */
    public Optional<ProphetStory> getProphetStory(String name) {
        // Step 1: Apply Chain of Responsibility for name processing
        String processedName;
        try {
            processedName = prophetNameChain.handle(name);
        } catch (IllegalArgumentException e) {
            // Handle validation errors from the chain
            System.err.println("Error processing prophet name: " + e.getMessage());
            mediator.notifyStoryNotFound(name); // Notify mediator even for validation errors
            return Optional.empty();
        }

        // Step 2: Use Bridge pattern to fetch the story (ProphetStoryFetcher handles the 'how')
        Optional<ProphetStory> story = prophetStoryFetcher.fetchStoryByName(processedName);

        // Step 3: Notify Mediator about the outcome
        if (story.isPresent()) {
            mediator.notifyStoryViewed(story.get()); // Story found, notify
        } else {
            mediator.notifyStoryNotFound(processedName); // Story not found, notify
        }
        return story;
    }

    /**
     * Retrieves a list of all prophet names.
     * Uses Bridge pattern for data fetching.
     * @return A list of prophet names.
     */
    public List<String> getAllProphetNames() {
        return prophetStoryFetcher.fetchAllProphetNames();
    }
}