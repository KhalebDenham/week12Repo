package promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			int c = a + b;
			return c;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	public int multiplyPositive(int a, int b) {
		if (a > 0 && b > 0) {
			int c = a * b;
			return c;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	public int randomNumberSquared() {
		int number = getRandomInt();
		
		return number * number;
		
	}
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
}
