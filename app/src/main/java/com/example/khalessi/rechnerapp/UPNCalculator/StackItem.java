package com.example.khalessi.rechnerapp.UPNCalculator;

public class StackItem implements IStackItem {
	private int type = UNKOWN;
	private float value = 0;

	public final static int UNKOWN = -1;
	public final static int NUMBER = 0;
	public final static int OP_ADD = 1;
	public final static int OP_MINUS = 2;
	public final static int OP_TIMES = 3;
	public final static int OP_DIVIDE = 4;

	
	public StackItem(int type, float val) {
		this.type = type;
		this.value = val;
	}
	
	@Override
	public float eval() {
		switch (type) {
		case NUMBER: 
			value = value;
			break;
		case OP_ADD:
			value = 0;
			break;
		case OP_MINUS:
			value = 0;
			break;
		case OP_TIMES:
			value = 0;
			break;
		case OP_DIVIDE:
			value = 0;
			break;
		}
		return value;
	}
	

	@Override
	public int getType() {
		return type;
	}

	@Override
	public float getValue() {
		return value;
	}
	
	
	/**
	 *  helper
	 * **/

	public String toString() {
		return ("StackItem: " +  type + " , " + value);
	}

}
