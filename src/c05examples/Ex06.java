package c05examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex06 {

	public static void main(String[] args) {
		Path p = Paths.get("C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\r05\\r05_01\\alice.txt");
		read_a(p);
		read_c(p);

	}

	private static void read_a(Path path) {
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Exception catch " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void read_c(Path path) {
		try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("Exception catch " + e.getMessage());
		}
	}

}
