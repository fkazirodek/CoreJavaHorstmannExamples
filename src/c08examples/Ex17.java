package c08examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex17 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			numbers.add(i);
			numbers.add(i);
		}
		
		List<Integer> list = numbers.parallelStream().distinct().collect(Collectors.toList());
		System.out.println(numbers.size());
		System.out.println("-----------------");
		System.out.println(list.size());
	}

}
