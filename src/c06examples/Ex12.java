package c06examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ex12 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			list.add(r.nextInt(10000));
		}
		
		minMax(list, (o1, o2) -> o1 - o2, result);
		System.out.println("Sorted list " + list);
		System.out.println("Min and max values " + result);
	}

	public static <T> void minMax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
		Collections.sort(elements, comp);
		T max = elements.get(0);
		T min = elements.get(elements.size() - 1);
		result.add(max);
		result.add(min);
	}
}
