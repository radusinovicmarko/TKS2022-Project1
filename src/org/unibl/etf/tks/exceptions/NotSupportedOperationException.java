package org.unibl.etf.tks.exceptions;

/**
 * Thrown to indicate that an unsupported operation was attempted.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class NotSupportedOperationException extends Exception {

	/**
	 * Used for serialization of object
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default message of the exception 
	 */
	private static final String MESSAGE = "Operation is not supported.";

	/**
	 * Constructs a NotSupportedOperationException with a default message.
	 */
	public NotSupportedOperationException() {
		super(MESSAGE);
	}
}
