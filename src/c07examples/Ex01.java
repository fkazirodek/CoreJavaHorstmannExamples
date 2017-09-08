package c07examples;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println(getPrimeNumbers(1022));
	}

	public static Set<Integer> getPrimeNumbers(int n) {
		Set<Integer> numbers = new HashSet<>();
		for (int i = 2; i <= n; i++) {
			numbers.add(i);
		}

		int s = 2;
		while (s * s < n) {
			for (int i = 0; i < numbers.size(); i++) {
				if (numbers.contains(s * (s + i))) {
					numbers.remove(s * (s + i));
				}
			}
			s++;
		}

		return numbers;
	}

}
