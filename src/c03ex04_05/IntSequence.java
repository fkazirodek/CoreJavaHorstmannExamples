package c03ex04_05;

import java.util.stream.IntStream;

public class IntSequence {

	public static ArithmeticProgression of(int... values) {
		return new ArithmeticProgression() {

			@Override
			public int[] getProggression() {
				for (int i = 0; i < values.length - 1; i++) {
					int min = values[i];
					for (int j = i + 1; j < values.length; j++) {
						if (values[j] < min) {
							min = values[j];
							values[j] = values[i];
							values[i] = min;
						}
					}
				}
				return values;
			}
		};
	}
	
	
	public static IntStream constant(int x) {
		return IntStream.generate(() -> x);
	}

}
