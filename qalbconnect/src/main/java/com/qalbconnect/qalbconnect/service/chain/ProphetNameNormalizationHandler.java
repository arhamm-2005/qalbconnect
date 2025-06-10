package com.qalbconnect.qalbconnect.service.chain;

import org.springframework.stereotype.Component;

/**
 * Chain of Responsibility Pattern: Concrete Handler
 * This handler normalizes the prophet name by trimming whitespace.
 * Other normalization (like case conversion) could be added here.
 */
@Component
public class ProphetNameNormalizationHandler extends BaseProphetNameHandler {

    @Override
    public String handle(String prophetName) {
        if (prophetName == null) {
            // Pass null to the next handler, or handle as an error earlier in the chain
            return callNextHandler(null);
        }
        String normalizedName = prophetName.trim(); // Example: trim spaces
        // You could add more complex normalization here, e.g., to Sentence case, remove special chars
        return callNextHandler(normalizedName);
    }
}