package c08examples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ex02 {

	public static void main(String[] args) throws IOException {
		String url = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\zemstax5.txt";
		String treść = new String(Files.readAllBytes(Paths.get(url)), StandardCharsets.UTF_8);
		List<String> słowa = Arrays.asList(treść.split("\\PL+"));

		long count = 0;
		long start = System.currentTimeMillis();
		count = słowa.stream().filter(w -> w.length() > 12).count();
		long stop = System.currentTimeMillis();
		System.out.println("Time 1 = " + (stop - start));

		long start_2 = System.currentTimeMillis();
		count = słowa.parallelStream().filter(w -> w.length() > 12).count();
		long stop_2 = System.currentTimeMillis();
		System.out.println("Time 2 = " + (stop_2 - start_2));
	}

}
