package c10examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex01 {

	public static void main(String[] args) {
		//path to dictionary
		String dir = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\pliki txt";
		findFilesContainsWord("nikt", dir).forEach(p -> System.out.println(p.toString()));
	}

	public static List<Path> findFilesContainsWord(String word, String dir) {
		List<Path> paths = null;
		try (Stream<Path> files = Files.walk(Paths.get(dir))) {
			paths = files.filter(p -> {
				if (p.toFile().isFile())
					try (Scanner sc = new Scanner(p)) {
						while (sc.hasNext()) {
							if (word.equalsIgnoreCase(sc.next()))
								return true;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				return false;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return paths;
	}

}
