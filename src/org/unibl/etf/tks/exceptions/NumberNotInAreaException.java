package org.unibl.etf.tks.exceptions;

/**
 * Thrown to indicate that a number is not in the valid area.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class NumberNotInAreaException extends Exception {
	
	/**
	 * Used for serialization of object
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default message of the exception 
	 */
	private static final String MESSAGE = "Number is not in the area.";
	
	/**
	 * Constructs a NumberNotInAreaException with a default message.
	 */
	public NumberNotInAreaException() {
		super(MESSAGE);
	}
}
