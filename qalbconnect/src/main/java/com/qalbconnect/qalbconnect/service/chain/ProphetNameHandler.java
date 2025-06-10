package com.qalbconnect.qalbconnect.service.chain;

/**
 * Chain of Responsibility Pattern: Handler Interface
 * Defines the interface for handling prophet names. Each handler in the chain
 * processes the request or passes it to the next handler.
 */
public interface ProphetNameHandler {
    String handle(String prophetName);
    void setNextHandler(ProphetNameHandler nextHandler);
}