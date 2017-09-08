package c07examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		String url = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		Map<String, Integer> words = getNumberOfWords(url);
		words.forEach((k, v) -> System.out.println(k + " " + v));
	}

	public static Map<String, Integer> getNumberOfWords(String url) {
		Map<String, Integer> map = new HashMap<>();
		try (Scanner sc = new Scanner(new File(url))) {
			while (sc.hasNext()) {
				String word = sc.next();
				map.merge(word, 1, Integer::sum);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
