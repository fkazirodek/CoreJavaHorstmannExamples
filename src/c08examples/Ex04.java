package c08examples;

import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		Double pow = Math.pow(2, 48);
		Stream<Long> s = linearCongruentialGenerator(1, 25214903917L, 11, pow.longValue());
		s.forEach(System.out::println);

	}

	private static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
		return Stream.iterate(seed, x -> (a * x + c) % m);
	}

}
