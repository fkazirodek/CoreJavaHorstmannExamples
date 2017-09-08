package c09examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		String from = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		try {
			createFile(from);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createFile(String uri) throws IOException {
		String filePath = Paths.get(uri).getParent().toString() + "\\zemsta.toc";
		List<String> words = new ArrayList<>();
		try (Scanner sc = new Scanner(Paths.get(uri));
				PrintWriter pw = new PrintWriter(
						Files.newBufferedWriter(Paths.get(filePath), Charset.defaultCharset()))) {

			while (sc.hasNext()) {
				words.add(sc.next());
			}
			Collections.sort(words);
			for (String word : words) {
				pw.println(word);
			}
		}
	}

}
