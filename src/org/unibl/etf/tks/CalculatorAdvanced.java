package org.unibl.etf.tks;

import org.unibl.etf.tks.exceptions.NotSupportedOperationException;
import org.unibl.etf.tks.exceptions.NumberNotInAreaException;

/**
 * Represents a class which extends basic Calculator class and offers additional operations
 * such as power and factorial functions. It also offers the ability to check if a number is prime or Armstrong's.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class CalculatorAdvanced extends Calculator {
	
	/**
	 * Constructs a CalculatorAdvanced object with a default initial value of its state of 0.
	 */
	public CalculatorAdvanced() {
		super();
	}

	/**
	 * Calculates power or factorial function, depending on the value of the parameter.
	 * If the argument is in range of '0' to '9', calculates integer part of the current value stored in the calculator to the power represented by the argument.
	 * If the argument is '!', calculates factorial of the integer part of the current value stored in the calculator.
	 * @param action Character which determines which function will be performed. Allowed values are '0' to '9' and '!'.
	 * @throws NotSupportedOperationException Thrown if parameter <i>action</i> is not allowed.
	 * @throws NumberNotInAreaException Thrown if parameter <i>action</i> is '!' and current value stored in the calculator is less than 0 or greater than 10.
	 */
	public void calculateAdvanced(char action) throws NotSupportedOperationException, NumberNotInAreaException {
		if (!((action >= '0' && action <= '9') || action == '!'))
			throw new NotSupportedOperationException();
		Integer intValue = getCurrentValue().intValue();
		if (action >= '0' && action <= '9') {
			int pow = action - '0';
			setCurrentValue((double)power(intValue, pow));
		} else {
			if (getCurrentValue() < 0 || getCurrentValue() > 10)
				throw new NumberNotInAreaException();
			setCurrentValue((double)fact(intValue));
		}
	}
	
	/**
	 * Checks whether the integer part of the current value stored in the calculator is prime or Armstrong's number, depending on the value
	 * of the parameter <i>value</i>. 
	 * @param value Character which determines whether the method checks if the integer part of the current value 
	 * stored in the calculator is prime or Armstrong's number. Allowed values are 'P' and 'A'.
	 * @return <b>true</b> if the integer part of the current value stored in the calculator is prime or Armstrong's number, 
	 * depending on the parameter <i>value</i>, <b>false</b> otherwise.
	 * @throws NotSupportedOperationException Thrown if parameter <i>value</i> is not one of 'P' or 'A'.
	 * @throws NumberNotInAreaException Thrown if the integer part of the current value stored in the calculator is prime or Armstrong's number is less than 1.
	 */
	public Boolean hasCharacteristic(char value) throws NotSupportedOperationException, NumberNotInAreaException {
		if (value != 'A' && value != 'P')
			throw new NotSupportedOperationException();
		Integer intValue = getCurrentValue().intValue();
		if (intValue < 1)
			throw new NumberNotInAreaException();
		if (value == 'A' && checkIfArmstrong(intValue))
			return true;
		if (value == 'P' && checkIfPerfect(intValue))
			return true;
		return false;
	}
	
	/**
	 * Checks whether the passed number is Armstrong's number.
	 * @param value Number to check.
	 * @return <b>true</b> if the number is Armstrong's number, <b>false</b> otherwise.
	 */
	private Boolean checkIfArmstrong(Integer value) {
		Integer numDigits = numberOfDigits(value);
		Integer temp = value, sum = 0;
		while (temp > 0) {
			sum += power(temp % 10, numDigits);
			temp /= 10;
		}
		return sum.equals(value);
	}
	
	/**
	 * Checks whether the passed number is a prime number. 
	 * @param value Number to check.
	 * @return <b>true</b> if the number is a prime number, <b>false</b> otherwise.
	 */
	private Boolean checkIfPerfect(Integer value) {
		Integer sum = 0;
		for (Integer i = 1; i <= value / 2; i++)
			if (value % i == 0)
				sum += i;
		return sum.equals(value);
	}
	
	/**
	 * Calculates number of digits of the argument.
	 * @param value Number for the calculation.
	 * @return Number of digits of the argument.
	 */
	private Integer numberOfDigits(Integer value) {
		Integer count = 0;
		while (value > 0) {
			count++;
			value /= 10;
		}
		return count;
	}
	
	/**
	 * Calculates the power function.
	 * @param value Base for the power function.
	 * @param exp Exponent for the power function.
	 * @return Parameter <i>value</i> to the power of the parameter <i>exp</i>.
	 */
	private Integer power(Integer value, Integer exp) {
		Integer p = 1;
		for (Integer i = 1; i <= exp; i++)
			p *= value;
		return p;
	}
	
	/**
	 * Calculates the factorial function.
	 * @param value Number to calculate factorial of.
	 * @return Factorial of the parameter <i>value</i>.
	 */
	private Integer fact(Integer value) {
		Integer f = 1;
		for (Integer i = 1; i <= value; i++)
			f *= i;
		return f;
	}
}
