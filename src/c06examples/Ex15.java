package c06examples;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class Ex15 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		addRandomElements(list, 100);
		System.out.println(list);
		ArrayList<String> list2 = map(list, (i) -> "Employee id = " + i);
		System.out.println(list2);
		
	}

	private static void addRandomElements(ArrayList<Integer> list, int numberOfElements) {
		Random r = new Random();
		for (int i = 0; i < numberOfElements; i++) {
			list.add(r.nextInt(10000));
		}
	}

	public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T, R> function) {
		ArrayList<R> newList = new ArrayList<>();
		for (T t : list) {
			newList.add(function.apply(t));
		}
		return newList;
	}
}
