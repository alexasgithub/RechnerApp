package com.example.khalessi.rechnerapp.UPNCalculator;

import java.util.ArrayList;
import java.util.Stack;

public class UPNStack {
	private ArrayList<StackItem> stack = new ArrayList<StackItem>();	
	private int errorState = 0;

	public UPNStack() {
		this.stack = new ArrayList<StackItem>();
		this.errorState = 0;
	}

	public void push(StackItem item) {
		stack.add(0, item);
	}

	public StackItem pop() throws IsEmptyException {
		if (!stack.isEmpty()) {
			StackItem item = stack.get(0);
			stack.remove(0);
			return item;
		} 
		
		// Fehler: Stack ist leer
		throw new IsEmptyException("pop() not possible on empty stack.");
	}

	public void print() {
		for (StackItem item : stack) {
			System.out.println(item.toString());
		}
	}

	/**
	 * Leeren des Stacks und Rücksetzen des ErrorStates
	 */
	public void clear() {
		stack.clear();;
		this.errorState = 0;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Evaluiert den aktuellen Stack
	 * Die Berechnung wird ausgeführt und der Stack wird geleert (im Idealfall)
	 *
	 *
 	 * @return den Wert der Berechnung
	 */
	public float evalAndPop() {
		try {
			StackItem item = pop();
			
			switch (item.getType()) {
			case StackItem.NUMBER: {
				return item.getValue();
			}		
			case StackItem.OP_ADD: {
				float v1 = evalAndPop();
				float v2 = evalAndPop();
				return v1 + v2;
			}
			case StackItem.OP_TIMES: {
				float v1 = evalAndPop();
				float v2 = evalAndPop();
				return v1 * v2;
			}
			case StackItem.OP_MINUS: {
				float v1 = evalAndPop();
				float v2 = evalAndPop();
				return v1 - v2;
			}
			case StackItem.OP_DIVIDE: {
				float v1 = evalAndPop();
				float v2 = evalAndPop();
				return v1 / v2;
			}
			}
			
		} catch (IsEmptyException e) {
			errorState++; // increasing error state
		}
		
		
		// sollte nicht passieren
		return 0;
	}
	
	public boolean isResultOk() {
		return ((errorState == 0) && stack.isEmpty());
	}
	

	public void testUPNStack() {
		UPNStack stack = new UPNStack();

		StackItem it5 = new StackItem(StackItem.NUMBER, 5);
		StackItem it2 = new StackItem(StackItem.NUMBER, 2);
		StackItem it6 = new StackItem(StackItem.NUMBER, 6);

		
		StackItem opAdd = new StackItem(StackItem.OP_ADD, 0);
		StackItem opTimes = new StackItem(StackItem.OP_TIMES, 0);
		StackItem opMinus = new StackItem(StackItem.OP_MINUS, 0);
		StackItem opDivide = new StackItem(StackItem.OP_DIVIDE, 0);

		stack.push(it2);
		stack.push(it2);
		stack.push(it5);
		stack.push(opMinus);
		stack.push(opAdd);
		stack.push(it2);
		stack.push(opDivide);
		stack.print();
		
		float ergebnis = stack.evalAndPop();
		System.out.println("Ergebnis ist " + ergebnis + ", " + stack.isResultOk());
	}
}
