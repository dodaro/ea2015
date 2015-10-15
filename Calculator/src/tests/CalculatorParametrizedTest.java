package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import calculator.Calculator;

@RunWith(value = Parameterized.class)
public class CalculatorParametrizedTest {

	private double expected;
	private double value;
	private static Calculator c;

	@BeforeClass
	public static void before() {
		c = new Calculator();
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, 1 }, { 2, 4 }, { 3, 9 }, { 4, 16 } });
	}

	public CalculatorParametrizedTest(double value, double expected) {
		this.expected = expected;
		this.value = value;
	}

	@Test
	public void square() {
		assertEquals("", c.square(value), expected, 0.001);
	}

}
