package c10examples;

import java.util.Arrays;
import java.util.Random;

public class Ex02_ArraysParallel {

	public static void main(String[] args) {
		Random r = new Random();
		int[] numbers = new int[100000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(100000);
		}

		System.out.println(Arrays.toString(numbers));
		
		long start = System.currentTimeMillis();
		Arrays.sort(numbers);
		long stop = System.currentTimeMillis();
		System.out.println("sort time = " + (stop - start));

		start = System.currentTimeMillis();
		Arrays.parallelSort(numbers);
		stop = System.currentTimeMillis();
		System.out.println("parallel sort time = " + (stop - start));
	}

}
