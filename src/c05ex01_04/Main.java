package c05ex01_04;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		MyReader reader = new MyReader();
		String fileName = "C:\\Users\\Filip\\Documents\\Programowanie\\Java\\Java 8 Horstmann\\r05\\numbers.txt";
		
//		try {
//			System.out.println(reader.readValues(fileName));
//			System.out.println(reader.sumOfValues(fileName));
//		} catch (FileNotFoundException e) {
//			Logger.getGlobal().log(Level.WARNING, "File not found", e);
//		} catch (NumberFormatException e) {
//			Logger.getGlobal().log(Level.WARNING, "Line is not a number", e);
//		}

		System.out.println(reader.readValues(fileName));
		System.out.println(reader.sumOfValues(fileName));
		
	}

}
