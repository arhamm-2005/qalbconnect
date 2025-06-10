package com.qalbconnect.qalbconnect.service.chain;

import org.springframework.stereotype.Component;

/**
 * Chain of Responsibility Pattern: Concrete Handler
 * This handler validates the prophet name to ensure it's not empty or blank.
 * If validation fails, it throws an exception, stopping the chain.
 */
@Component
public class ProphetNameValidationHandler extends BaseProphetNameHandler {

    @Override
    public String handle(String prophetName) {
        if (prophetName == null || prophetName.isBlank()) {
            throw new IllegalArgumentException("Prophet name cannot be empty or blank.");
        }
        // If valid, pass to the next handler (if any)
        return callNextHandler(prophetName);
    }
}