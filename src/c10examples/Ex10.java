package c10examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Ex10 {

	public static void main(String[] args) {
		String dir = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\pliki txt";
		BlockingQueue<File> queue = new ArrayBlockingQueue<>(5);
		searchWord(queue, dir, "nikt");

	}

	private static void searchWord(BlockingQueue<File> queue, String dir, String word) {
		addFilesToQueue(dir, queue);
		Runnable task = getTask(queue, word);
		for (int i = 0; i < 5; i++) {
			new Thread(task).start();
		}
	}

	private static Runnable getTask(BlockingQueue<File> queue, String word) {
		Runnable task = () -> {
			do {
				File file = getFileFromQueue(queue);
				try (Scanner sc = new Scanner(file)) {
					System.out.println(Thread.currentThread().getName() + " search " + file.getName());
					System.out.println("queue size = " + queue.size());
					while (sc.hasNext()) {
						if (word.equalsIgnoreCase(sc.next())) {
							System.out.println(Thread.currentThread().getName() + " find word '" + word + "' in file "
									+ file.getName());
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchElementException e) {
					e.printStackTrace();
				}
			} while (queue.size() > 0);
		};
		return task;
	}

	private static void addFilesToQueue(String dir, BlockingQueue<File> queue) {
		Runnable task = () -> {
			try {
				Files.walk(Paths.get(dir))
						.filter(p -> p.toFile().isFile())
						.forEach(f -> {
							try {
								System.out.println("add file to queue");
								queue.put(f.toFile());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						});
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		new Thread(task).start();
	}

	private static File getFileFromQueue(BlockingQueue<File> queue) {
		File file = null;
		try {
			file = queue.take();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return file;
	}

}
