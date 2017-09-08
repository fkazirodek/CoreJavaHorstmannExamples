package c06ex07_11;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Pair<Integer>> pairs = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			numbers.add(i);
		}
		numbers.add(7);
		Pair<Integer> pair1 = new Pair<Integer>(4, 6);
		Pair<Integer> pair2 = new Pair<Integer>(3, 2);
		Pair<Integer> pair3 = new Pair<Integer>(0, 10);
		Pair<Integer> pair4 = new Pair<Integer>(5, 9);
		Pair<Integer> pair5 = new Pair<Integer>(0, 7);
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		pairs.add(pair4);
		pairs.add(pair5);

		System.out.println(Arrays.firstLast(numbers, pairs));
		System.out.println(Arrays.minMax(pairs));

	}

}
