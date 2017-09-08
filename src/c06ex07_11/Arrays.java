package c06ex07_11;

import java.util.ArrayList;

public class Arrays {

	// return Pair contains first and last element form ArrayList a
	public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> a, ArrayList<Pair<E>> pairs) {
		E first = a.get(0);
		E last = a.get(a.size() - 1);
		Pair<E> pair = null;
		for (Pair<E> p : pairs) {
			if ((p.getFirst().equals(first) || p.getSecond().equals(first))
					&& (p.getSecond().equals(last) || p.getFirst().equals(last))) {
				pair = p;
			}
		}
		return pair;
	}

	public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<Pair<E>> pairs) {
		Pair<E> minMax = pairs.get(0);
		E max = pairs.get(0).max();
		E min = pairs.get(0).min();
		for (Pair<E> pair : pairs) {
			if (pair.max().compareTo(max) > 0 && pair.min().compareTo(min) < 0) {
				max = pair.max();
				min = pair.min();
				minMax = pair;
			}
		}
		return minMax;
	}

}
