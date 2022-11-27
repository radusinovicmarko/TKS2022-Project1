package org.unibl.etf.tks.exceptions;

/**
 * Thrown to indicate that an unsupported operation was attempted.
 * @author Marko Radusinovic
 * @version 1.0
 * @since 2022-11-25
 *
 */
public class NotSupportedOperationException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Operation is not supported.";

	/**
	 * Constructs a NotSupportedOperationException with a default message.
	 */
	public NotSupportedOperationException() {
		super(MESSAGE);
	}
}
