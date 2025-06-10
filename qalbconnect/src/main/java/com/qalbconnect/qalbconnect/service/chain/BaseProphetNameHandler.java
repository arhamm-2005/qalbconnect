package com.qalbconnect.qalbconnect.service.chain;

/**
 * Chain of Responsibility Pattern: Base Handler
 * Provides default implementation for setting the next handler and passing the request along the chain.
 * Concrete handlers will extend this class.
 */
public abstract class BaseProphetNameHandler implements ProphetNameHandler {
    private ProphetNameHandler nextHandler;

    @Override
    public void setNextHandler(ProphetNameHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // This method allows handlers to pass the request to the next in chain
    protected String callNextHandler(String prophetName) {
        if (nextHandler != null) {
            return nextHandler.handle(prophetName);
        }
        return prophetName; // If no next handler, return the processed name
    }
}