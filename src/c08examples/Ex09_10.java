package c08examples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex09_10 {

	public static void main(String[] args) {
		String url = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		try {
			System.out.printf("Average word lenght = %.2f", getAverageWordsLenght(url));
			System.out.println();

			getLongestWords(url).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static double getAverageWordsLenght(String url) throws IOException {
		List<String> list = fileTextToArray(url);
		return list.stream()
						.mapToInt(String::length)
						.average()
							.getAsDouble();
	}

	private static ArrayList<String> getLongestWords(String url) throws IOException {
		List<String> list = fileTextToArray(url);
		return list.stream()
						.filter(s -> s.length() > 12)
						.collect(Collectors.toCollection(ArrayList::new));
	}

	private static List<String> fileTextToArray(String url) throws IOException {
		String text = new String(Files.readAllBytes(Paths.get(url)), StandardCharsets.UTF_8);
		return Arrays.asList(text.split("\\PL+"));
	}

}
