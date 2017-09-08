package c07examples;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex02 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");

		toUpperCase_a(list);
		//toUpperCase_b(list);
		//toUpperCase_c(list);
		System.out.println(list);
	}

	public static void toUpperCase_a(List<String> list) {
		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			listIterator.set(listIterator.next().toUpperCase());
		}
	}

	public static void toUpperCase_b(List<String> list) {
		for (int i = 0; i < list.size(); i++) {	
			list.set(i, list.get(i).toUpperCase());
		}
	}

	public static void toUpperCase_c(List<String> list) {
		list.replaceAll(String::toUpperCase);
	}
	
}
