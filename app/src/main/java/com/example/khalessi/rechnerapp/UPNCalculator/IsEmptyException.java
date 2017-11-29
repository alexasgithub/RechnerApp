package com.example.khalessi.rechnerapp.UPNCalculator;

public class IsEmptyException extends Exception {

	public IsEmptyException(String message) {
		super("Stack empty exception: trying to access emoty stack. " + message);
	}
}
