package c09ex14;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String uri = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\serializable.txt";
		Point[] points = new Point[4];
		for (int i = 0; i < 4; i++) {
			points[i] = new Point(i, i + 1);
		}
		System.out.println(Arrays.toString(points));
		//save(points, uri);
		System.out.println(Arrays.toString(read(uri)));
	}

	private static void save(Point[] points, String uri) {
		try (ObjectOutputStream out = new ObjectOutputStream(
				Files.newOutputStream(Paths.get(uri), StandardOpenOption.APPEND))) {
			for (Point point : points) {
				out.writeObject(point);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Point[] read(String uri) {
		Point[] points = new Point[4];
		try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(uri)))) {
			Point point;
			int i = 0;
			while ((point = (Point) in.readObject()) != null) {
				points[i] = point;
				i++;
			}
		} catch (EOFException eof) {
			// bad solution
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return points;
	}
}
