package c05examples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		String fromFile = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\r05\\r05_01\\alice.txt";
		String toFile = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\r05\\output.txt";

		copyFile(fromFile, toFile);
	}

	public static void copyFile(String fromFile, String toFile) {
		Scanner in = null;
		PrintWriter write = null;
		try {
			in = new Scanner(Paths.get(fromFile));
			write = new PrintWriter(toFile);
			while (in.hasNext()) {
				write.println(in.nextLine());
			}
			System.out.println("The file has been copied");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (write != null) {
				write.close();
			}
		}
	}

}
