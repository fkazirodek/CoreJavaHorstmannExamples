package c03ex07;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("abc");
		strings.add("a");
		strings.add("abcdef");
		strings.add("ab");
		strings.add("abcde");
		strings.add("abcd");
		Sort sort = new Sort();
		sort.luckySort(strings, (s1, s2) -> s1.length() - s2.length());

	}

}
