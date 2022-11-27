package org.unibl.etf.tks.exceptions;

/**
 * Thrown to indicate that a number is not in the valid area.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class NumberNotInAreaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Number is not in the area.";
	
	/**
	 * Constructs a NumberNotInAreaException with a default message.
	 */
	public NumberNotInAreaException() {
		super(MESSAGE);
	}
}
