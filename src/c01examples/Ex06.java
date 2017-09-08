package c01examples;

import java.math.BigInteger;

public class Ex06 {

	public static void main(String[] args) {
		System.out.println(getFactorial(1000));
	}

	private static BigInteger getFactorial(int from) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = 1; i <= from; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}
}
