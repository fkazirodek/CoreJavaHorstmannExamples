package c02ex10;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		int[] numbers_1 = new int[100];
		for (int i = 0; i < 100; i++) {
			numbers.add(i);
			numbers_1[i] = i;
		}
		System.out.println(RandomNumbers.randomElement(numbers));
		System.out.println(RandomNumbers.randomElement(numbers_1));
	}

}
