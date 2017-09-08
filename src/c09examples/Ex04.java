package c09examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04 {

	public static void main(String[] args) {
		String uri = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemsta.txt";
		readFile_a(uri);
		readFile_b(uri);
		readFile_c(uri);
	}

	private static List<String> readFile_a(String uri) {
		long start = System.currentTimeMillis();
		List<String> list = new ArrayList<>();
		int count = 0;
		try (Scanner sc = new Scanner(Paths.get(uri))) {
			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Scanner time = " + (stop - start));
		System.out.println("Number of words = " + count);
		return list;
	}

	private static List<String> readFile_b(String uri) {
		long start = System.currentTimeMillis();
		List<String> list = new ArrayList<>();
		int count = 0;
		String line = null;
		try (BufferedReader br = Files.newBufferedReader(Paths.get(uri))) {
			while ((line = br.readLine()) != null) {
				list.add(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("BufferedReader time = " + (stop - start));
		System.out.println("Number of words = " + count);
		return list;
	}

	private static List<String> readFile_c(String uri) {
		long start = System.currentTimeMillis();
		List<String> list = null;
		long count = 0;
		try (BufferedReader br = Files.newBufferedReader(Paths.get(uri))) {
			count = br.lines().count();
			list = br.lines().collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Stream time = " + (stop - start));
		System.out.println("Number of words = " + count);
		return list;
	}

}
