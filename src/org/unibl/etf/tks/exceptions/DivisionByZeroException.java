package org.unibl.etf.tks.exceptions;

/**
 * Thrown to indicate that a division by zero is attempted.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class DivisionByZeroException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Division by zero.";

	/**
	 * Constructs a DivisionByZeroException with a default message.
	 */
	public DivisionByZeroException() {
		super(MESSAGE);
	}

}
