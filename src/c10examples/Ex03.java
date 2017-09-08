package c10examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Ex03 {

	public static void main(String[] args) {
		String dir = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\pliki txt";
		ExecutorService exec = Executors.newCachedThreadPool();
		
		try {
			List<Callable<Path>> list = Files.walk(Paths.get(dir)).map(p -> task(p, "nikt")).collect(Collectors.toList());
			System.out.println(exec.invokeAny(list));
			exec.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Callable<Path> task(Path filePath, String word) {
		Callable<Path> task = () -> {
			if (filePath.toFile().isFile()) {
				try (Scanner sc = new Scanner(filePath)) {
					while (sc.hasNext()) {
						if (word.equalsIgnoreCase(sc.next())) {
							return filePath;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			throw new ExecutionException(null);
		};
		return task;
	}

}
