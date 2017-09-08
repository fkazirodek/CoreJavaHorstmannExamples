package c07examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex14 {

	public static void main(String[] args) {
		List<Integer> list = getList(100);
		// list.add(2); UnsupportedOperationException
	}

	public static List<Integer> getList(int n) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			numbers.add(i);
		}
		return Collections.unmodifiableList(numbers);
	}

}
