package c07examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Ex05 {

	public static void main(String[] args) {
		//List<Integer> list = new LinkedList<>(); // don't implement RandomAccess
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		replace(list, 2, 0);
		System.out.println(list);

	}

	// Since we don't know what the element type ? is, we cannot add and get
	// objects
	public static void replace(List<?> list, int i, int j) {
		replaceHelper(list, i, j);
	}

	
	// help method with type E
	private static <E> void replaceHelper(List<E> list, int i, int j) {
		if (list instanceof RandomAccess) {
			E temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		} else {
			E temp_i = list.get(i);
			E temp_j = list.get(j);
			ListIterator<E> listIterator = list.listIterator();
			while (listIterator.hasNext()) {
				listIterator.next();
				if (listIterator.nextIndex() - 1 == i) {
					listIterator.set(temp_j);
				}
				if (listIterator.nextIndex() - 1 == j) {
					listIterator.set(temp_i);
				}
			}
		}
	}

}
