package c08examples;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex15 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		primeNumbers(500).forEach(System.out::println);
		long stop = System.currentTimeMillis();;
		System.out.println("Time = " + (stop - start));
	}

	private static List<BigInteger> primeNumbers(int limit) {
		return Stream
				.generate(() -> new BigInteger(168, new Random()).nextProbablePrime())
					.limit(limit)
					.collect(Collectors.toList());
	}

}
