package com.qalbconnect.qalbconnect.service.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.qalbconnect.qalbconnect.model.ProphetStory;

/**
 * Mediator Pattern: Mediator
 * Defines an object that encapsulates how a set of objects (colleagues) interact.
 * It promotes loose coupling by keeping objects from referring to each other explicitly.
 * Here, it mediates events related to prophet story viewing.
 */
@Component
public class ProphetStoryEventMediator {

    private static final Logger logger = LoggerFactory.getLogger(ProphetStoryEventMediator.class);

    // In a real application, you would inject other services here
    // For example:
    // private AnalyticsService analyticsService;
    // private LoggingService customLoggingService;
    // private NotificationService notificationService;

    /**
     * Notifies the mediator that a prophet story has been successfully viewed.
     * The mediator then orchestrates any necessary actions from other components (colleagues).
     * @param story The ProphetStory that was viewed.
     */
    public void notifyStoryViewed(ProphetStory story) {
        logger.info("MEDIATOR: Prophet story '{}' viewed.", story.getName());
        // Example actions the mediator could orchestrate:
        // analyticsService.recordStoryView(story.getName());
        // customLoggingService.logStoryAccess(story.getName(), System.currentTimeMillis());
        // notificationService.suggestRelatedContent(story.getName());
    }

    /**
     * Notifies the mediator that an attempt to view a story failed because it was not found.
     * @param prophetName The name of the prophet for which the story was not found.
     */
    public void notifyStoryNotFound(String prophetName) {
        logger.warn("MEDIATOR: Story for prophet '{}' not found.", prophetName);
        // analyticsService.recordStoryNotFoundAttempt(prophetName);
    }
}