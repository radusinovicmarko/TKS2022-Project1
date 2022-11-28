package org.unibl.etf.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.Matchers.is;
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
import org.unibl.etf.tks.CalculatorAdvanced;
import org.unibl.etf.tks.exceptions.DivisionByZeroException;
import org.unibl.etf.tks.exceptions.NotSupportedOperationException;
import org.unibl.etf.tks.exceptions.NumberNotInAreaException;

@DisplayName("CalculateAdvanced Tests")
class CalculatorAdvancedTest {
	
	private CalculatorAdvanced calc = new CalculatorAdvanced();

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
	
	@DisplayName("CalculatorAdvanced Constructor Tests")
	@Test
	void constructorTest() {
		CalculatorAdvanced calculator = new CalculatorAdvanced();
		assertThat(calculator, notNullValue());
		assertThat(calculator.getCurrentValue(), is(0.0));
	}
	
	@DisplayName("calculateAdvanced Method Tests")
	@ParameterizedTest
	@MethodSource("calculateAdvancedTests")
	void calculateAdvancedTest(Double currentValue, char option, Double result) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calc.setCurrentValue(currentValue);
		calc.calculateAdvanced(option);
		assertThat(result, is(calc.getCurrentValue()));
	}
	
	private static Stream<Arguments> calculateAdvancedTests() {
		return Stream.of(Arguments.of(0.0, '0', 1.0),
				Arguments.of(10.0, '0', 1.0),
				Arguments.of(0.0, '9', 0.0),
				Arguments.of(10.0, '2', 100.0),
				Arguments.of(10.0, '1', 10.0),
				Arguments.of(2.0, '9', 512.0),
				Arguments.of(0.0, '!', 1.0),
				Arguments.of(10.0, '!', 3628800.0));
	}
	
	@DisplayName("calculateAdvanced Method Exceptions Test")
	@ParameterizedTest
	@MethodSource("calculateAdvancedTestsException")
	void calculateAdvancedTest(Double currentValue, char option, Class<? extends Exception> exceptionClass) throws NotSupportedOperationException, NumberNotInAreaException, DivisionByZeroException {
		calc.setCurrentValue(currentValue);
		Exception exc = assertThrows(exceptionClass, () -> calc.calculateAdvanced(option));
		assertThat(exc, is(instanceOf(exceptionClass)));
	}
	
	private static Stream<Arguments> calculateAdvancedTestsException() {
		return Stream.of(Arguments.of(0.0, 'x', NotSupportedOperationException.class),
				Arguments.of(-1.0, '!', NumberNotInAreaException.class),
				Arguments.of(10.01, '!', NumberNotInAreaException.class));
	}
	
	@DisplayName("hasCharacteristics Method Tests")
	@ParameterizedTest
	@MethodSource("hasCharacteristicsTests")
	void hasCharacteristicsTest(Double value, char option, Boolean result) throws NotSupportedOperationException, NumberNotInAreaException {
		calc.setCurrentValue(value);
		assertThat(result, is(calc.hasCharacteristic(option)));
	}
	
	private static Stream<Arguments> hasCharacteristicsTests() {
		return Stream.of(Arguments.of(153.0, 'A', true),
				Arguments.of(154.0, 'A', false),
				Arguments.of(6.0, 'P', true),
				Arguments.of(7.0, 'P', false),
				Arguments.of(1.0, 'P', false));
	}
	
	@DisplayName("hasCharacteristicsTest Method Exceptions Test")
	@ParameterizedTest
	@MethodSource("hasCharacteristicsTestsException")
	void hasCharacteristicsExceptionsTest(Double value, char option, Class<? extends Exception> exceptionClass) throws NotSupportedOperationException, NumberNotInAreaException {
		calc.setCurrentValue(value);
		Exception exc = assertThrows(exceptionClass, () -> calc.hasCharacteristic(option));
		assertThat(exc, is(instanceOf(exceptionClass)));
	}
	
	private static Stream<Arguments> hasCharacteristicsTestsException() {
		return Stream.of(Arguments.of(6.0, 'p', NotSupportedOperationException.class),
				Arguments.of(0.99, 'P', NumberNotInAreaException.class));
	}
	
	

}
