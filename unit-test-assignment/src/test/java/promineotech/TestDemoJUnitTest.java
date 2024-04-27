package promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {

		return Stream.of(arguments(2, 4, 6, false), arguments(4, 4, 8, false), arguments(2, 5, 7, false),
				arguments(-2, -1, -1, false), arguments(0, 0, 0, false), arguments(1, -2, -1, false),
				arguments(4, 4, 8, true), arguments(2, 4, 6, true), arguments(2, -4, -2, true),
				arguments(0, 0, 0, true));
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(2, 4)).isEqualTo(6);
		assertThat(testDemo.addPositive(4, 4)).isEqualTo(8);
		assertThat(testDemo.addPositive(2, 5)).isEqualTo(7);
		assertThat(testDemo.addPositive(100, 50)).isEqualTo(150);
		assertThat(testDemo.addPositive(40, 35)).isEqualTo(75);
		assertThat(testDemo.addPositive(200, 200)).isEqualTo(400);
		assertThat(testDemo.addPositive(325, 325)).isEqualTo(650);

	}
	
	@ParameterizedTest
	@MethodSource("promineotech.TestDemoJUnitTest#argumentsForMultiplyPositive")
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) { //if the exception is false
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected); //assert that multiply positive a and b is equal
			//to the expected integer
			
		} else { //otherwise
			assertThatThrownBy(() -> testDemo.multiplyPositive(a, b)).isInstanceOf(IllegalArgumentException.class); //lamba
			//expression calling assert that thrown by the test demo is an instance of the illegal argument exception class
		}
		
	}
	static Stream<Arguments> argumentsForMultiplyPositive() {

		return Stream.of(arguments(2, 4, 8, false), arguments(6, 2, 12, false), arguments(6, 8, 48, false), arguments(2, 2, 5, false), arguments(-2, 4, -8, false),
				arguments(2, -5, -10, false), arguments(0, 0, 0, false), arguments(-2, -5, 10, false), arguments(2, 2, 4, true));
	}
	
	@Test
	 void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}

}
