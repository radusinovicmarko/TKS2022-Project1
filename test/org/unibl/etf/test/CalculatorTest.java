package org.unibl.etf.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.unibl.etf.tks.Calculator;
import org.unibl.etf.tks.exceptions.DivisionByZeroException;
import org.unibl.etf.tks.exceptions.NotSupportedOperationException;
import org.unibl.etf.tks.exceptions.NumberNotInAreaException;

@DisplayName("Calculator Tests")
class CalculatorTest {
	
	private Calculator calc = new Calculator();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@DisplayName("Calculator Constructor Tests")
	@Test
	void constructorTest() {
		Calculator calculator = new Calculator();
		assertThat(calculator, notNullValue());
		assertThat(calculator.getCurrentValue(), is(0.0));
	}

	@DisplayName("calculate Method Tests")
	@ParameterizedTest
	@MethodSource("calculateTests")
	void calculateTest(Double currentValue, Double value, char option, Double result) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calc.setCurrentValue(currentValue);
		calc.calculate(value, option);
		assertThat(result, is(closeTo(calc.getCurrentValue(), 0.0001)));
	}
	
	private static Stream<Arguments> calculateTests() {
		return Stream.of(Arguments.of(0.0, 10.0, '+', 10.0),
				Arguments.of(0.0, 10.0, '-', -10.0),
				Arguments.of(0.0, 10.0, '*', 0.0),
				Arguments.of(1.0, 10.0, '*', 10.0),
				Arguments.of(0.0, 10.0, '/', 0.0),
				Arguments.of(10.0, 2.0, '/', 5.0));
	}
	
	@DisplayName("calculate Method Exceptions Test")
	@ParameterizedTest
	@MethodSource("calculateTestsException")
	void calculateTestExceptions(Double currentValue, Double value, char option, Class<? extends Exception> exceptionClass) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calc.setCurrentValue(currentValue);
		Exception exc = assertThrows(exceptionClass, () -> calc.calculate(value, option));
		assertThat(exc, is(instanceOf(exceptionClass)));
	}
	
	private static Stream<Arguments> calculateTestsException() {
		return Stream.of(Arguments.of(0.0, 10.0, '%', NotSupportedOperationException.class),
				Arguments.of(10.0, 0.0, '/', DivisionByZeroException.class));
	}
}
