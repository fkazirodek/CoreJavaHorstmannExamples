package c03ex04_05;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		int[] array = { 4, 2, 7, 10, 1, 3, 9, 5, 8, 6 };
		ArithmeticProgression ap = IntSequence.of(array);
		System.out.println(Arrays.toString(ap.getProggression()));
		
//		example 5
//		IntStream constant = IntSequence.constant(1);
//		constant.forEach(System.out::println);
		
	}
}
