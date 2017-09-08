package c07examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		String url = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		shuffleWords(url);
	}

	public static void shuffleWords(String url) {
		List<String> list = new ArrayList<>();
		try (Scanner sc = new Scanner(new File(url))) {
			while (sc.hasNext()) {
				String word = sc.next();
				list.add(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.shuffle(list);
		list.forEach(System.out::println);
	}

}
