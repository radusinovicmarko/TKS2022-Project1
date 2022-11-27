package org.unibl.etf.tks;

import org.unibl.etf.tks.exceptions.DivisionByZeroException;
import org.unibl.etf.tks.exceptions.NotSupportedOperationException;

/**
 * Represents a simple class used to demonstrate basic arithmetic operations, 
 * such as addition, subtraction, multiplication and division. It has one member which represents 
 * current state of the calculator and which changes after every calculation.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class Calculator {
	
	/**
	 * Represents current value stored in the calculator. When an object is created, current value is 0.
	 */
	private Double currentValue = 0.0;
	
	

	/**
	 * Constructs a Calculator object with a default initial value of its state of 0.
	 */
	public Calculator() {
		super();
	}

	/**
	 * Retrieves the current current value stored in the calculator.
	 * @return The value stored in the calculator.
	 */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
	 * Sets the current current value stored in the calculator.
	 * @param currentValue The value that will be stored in the calculator 
	 * and that will represent its state.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	/**
	 * Performs simple arithmetic operations which include addition, subtraction, multiplication and division.
	 * whereby the first operand in the operation is the value stored in the calculator, and the second operand is passed as a second argument of the method.
	 * The result of the operation will be stored in the calculator as its current state.
	 * @param value The second operand in the operation that will be performed by the calculator.
	 * @param operator Indicates which operation will be performed. Supported operations are <b>+</b>, <b>-</b>, <b>*</b> and <b>/</b>.
	 * @throws NotSupportedOperationException Thrown if parameter <i>operation</i> is not one of <b>+</b>, <b>-</b>, <b>*</b> or <b>/</b>.
	 * @throws DivisionByZeroException Thrown if parameter <i>operation</i> is <b>/</b> and parameter <i>value</i> is <b>0</b>.
	 */
	public void calculate(Double value, char operator) throws NotSupportedOperationException, DivisionByZeroException {
		switch (operator) {
		case '+':
			currentValue += value;
			break;
		case '-':
			currentValue -= value;
			break;
		case '*':
			currentValue *= value;
			break;
		case '/':
			if (value == 0)
				throw new DivisionByZeroException();
			currentValue /= value;
			break;
		default:
			throw new NotSupportedOperationException();
		}
	}

}
