package c01examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex13 {

	public static void main(String[] args) {

		List<Integer> numbers = createArrayListWithNumbers();
		System.out.println(randomNumbers(numbers));

	}

	private static List<Integer> createArrayListWithNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	private static List<Integer> randomNumbers(List<Integer> numbers) {
		List<Integer> chosenNumbers = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Collections.shuffle(numbers);
			chosenNumbers.add(numbers.get(0));
			numbers.remove(0);
		}
		Collections.sort(chosenNumbers);
		return chosenNumbers;
	}
}
