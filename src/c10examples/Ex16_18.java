package c10examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Ex16_18 {

	//private static int count = 0;
	private static LongAdder longAdder = new LongAdder();

	public static void main(String[] args) {
		String dir = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\pliki txt";
		countWords(dir);
	}

	private static void countWords(String dir) {
		Lock lock = new ReentrantLock();
		for (File file : getFilesList(dir)) {
			new Thread(getTask(file, lock)).start();
		}
	}

	private static Runnable getTask(File file, Lock lock) {
		Runnable task = () -> {
			try (Scanner sc = new Scanner(file)) {
				System.out.println(Thread.currentThread().getName() + " count words in " + file.getName());
				//lock.lock();
				while (sc.hasNext()) {
					sc.next();
					longAdder.increment();
					//count++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			} finally {
				//lock.unlock();
			}
			//System.out.println(count);
			System.out.println(longAdder.longValue());
		};
		return task;
	}

	private static List<File> getFilesList(String dir) {
		List<File> files = null;
		try {
			files = Files.walk(Paths.get(dir)).map(p -> p.toFile()).filter(f -> f.isFile())
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;
	}

}