package c10examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Ex05_Words {

	public static void main(String[] args) {
		String dir = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\pliki txt";
		Map<String, Set<File>> words = readWords(dir);
		for (Entry<String, Set<File>> entry : words.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	private static Map<String, Set<File>> readWords(String dir) {
		Map<String, Set<File>> map = new ConcurrentHashMap<>();
		Set<Path> pathsFile = getFilesFromDictionary(dir);

		for (int i = 0; i < 10; i++) {
			Runnable r = () -> {
				for (Path path : pathsFile) {
					try (Scanner sc = new Scanner(path)) {
						while (sc.hasNext()) {
							// ???
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			new Thread(r).start();
		}
		return map;
	}

	private static Set<Path> getFilesFromDictionary(String dir) {
		Set<Path> files = new HashSet<>();
		try {
			files = Files.walk(Paths.get(dir)).filter(p -> p.toFile().isFile()).collect(Collectors.toSet());
		} catch (IOException e) {
			e.printStackTrace();
		}
		files.forEach(System.out::println);
		return files;
	}
}
