package c09examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Ex01 {

	public static void main(String[] args) {
		String from = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		String to = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta_copy.txt";
		// copy(from, to);
		copyFiles(from, to);

	}

	private static void copy(String from, String to) {
		try (InputStream in = Files.newInputStream(Paths.get(from), StandardOpenOption.READ);
				OutputStream out = Files.newOutputStream(Paths.get(to), StandardOpenOption.CREATE)) {
			int i = 0;
			while ((i = in.read()) > 0) {
				out.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyFiles(String from, String to) {
		try {
			Files.copy(Paths.get(from), Paths.get(to), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
