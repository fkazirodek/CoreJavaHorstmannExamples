package c03ex07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

	public void luckySort(ArrayList<String> strings, Comparator<String> comp) {
		ArrayList<String> unsorted = new ArrayList<>(strings);
		Collections.sort(strings, comp);

		boolean condition;
		do {
			Collections.shuffle(unsorted);
			condition = isNotEqual(strings, unsorted);
			System.out.println(unsorted);
		} while (condition);
	}

	private boolean isNotEqual(List<String> list1, List<String> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return true;
			}
		}
		return false;
	}
}
