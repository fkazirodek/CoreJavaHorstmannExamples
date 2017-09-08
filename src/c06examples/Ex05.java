package c06examples;

public class Ex05 {

	public static void main(String[] args) {

		exchange(0, 1, 1.5, 2, 5);
		
		//Double[] result = Main.<Double>exchange(0, 1, 1.5, 2, 5);

	}
	
	private static <T> T[] exchange(int i, int j, T...values) {
		T temp = values[i];
		values[i] = values[j];
		values[j] = temp;
		return values;
	}

//	private static <T> T[] exchange(int i, int j, T[] values) {
//		T temp = values[i];
//		values[i] = values[j];
//		values[j] = temp;
//		return values;
//	}
	
}
