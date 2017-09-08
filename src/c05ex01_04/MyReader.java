package c05ex01_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyReader {
//	Example 1
//	public ArrayList<Double> readValues(String fileName) throws FileNotFoundException, NumberFormatException {
//		ArrayList<Double> numbers = new ArrayList<>();
//		try (Scanner sc = new Scanner(new File(fileName))) {
//			while (sc.hasNextLine()) {
//				String nextLine = sc.nextLine();
//				numbers.add(Double.parseDouble(nextLine));
//			}
//		}
//		return numbers;
//	}
//
//  Example 2	
//	public double sumOfValues(String fileName) throws FileNotFoundException, NumberFormatException {
//		ArrayList<Double> numbers = readValues(fileName);
//		double sum = 0;
//		for (Double d : numbers) {
//			sum += d;
//		}
//		return sum;
//	}

	public ArrayList<Double> readValues(String fileName) {
		ArrayList<Double> numbers = new ArrayList<>();
		int count = 1;
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				numbers.add(Double.parseDouble(nextLine));
				count++;
			}
		} catch (FileNotFoundException ex) {
			Logger.getGlobal().log(Level.WARNING, "File not found", ex);
		} catch(NumberFormatException ex) {
			Logger.getGlobal().log(Level.WARNING, "Line " + count + " is not a number", ex);
			return null;
		}
		return numbers;
	}

	public double sumOfValues(String fileName) {
		ArrayList<Double> numbers = readValues(fileName);
		if(numbers == null) {
			return Double.NaN;
		}
		double sum = 0;
		for (Double d : numbers) {
			sum += d;
		}
		return sum;
	}

}
