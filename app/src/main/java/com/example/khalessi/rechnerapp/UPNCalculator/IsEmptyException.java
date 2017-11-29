package com.example.khalessi.rechnerapp.UPNCalculator;

/**
 * Dieses Exception wird ausgelöst, wenn ein Fehler in der Verwendung des
 * UPNStacks passiert.
 *
 * Beispielsweise: pop()-Operation auf einen leeren Stack
 *
 */
public class IsEmptyException extends Exception {

    public IsEmptyException(String message) {
        super("Stack empty exception: trying to access empty stack. " + message);
    }
}
