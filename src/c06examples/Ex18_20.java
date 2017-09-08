package c06examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

public class Ex18_20 {

	public static void main(String[] args) {
		// repeat(10, 1, int[]::new); does not work because of the default value of int cannot be null (T[] will be filled the null values in repeat method)
		
		//ArrayType[]::new is a method reference to an array constructor. 
		//When you create an instance of an array, the elements are initialized to the default value for the array's type, 
		//and the default value for reference types is null.
		
		Integer[] numbers = repeat(10, 1, Integer[]::new);
		System.out.println(Arrays.toString(numbers));
		
		System.out.println(repeat(10, 4));
		
		System.out.println(Arrays.toString(repeat(10, 1, 3, 5, 7, 11)));
	}
	
	public static <T> T[] repeat(int n, T obj, IntFunction<T[]> function) {
		T[] result = function.apply(n);
		for (int i = 0; i < n; i++) {
			result[i] = obj;
		}
		return result;
	}
	
	public static <T> ArrayList<T> repeat(int n, T obj) {
		ArrayList<T> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(obj);
		}
		//T[] array = new T[]; cannot create new array in this way
		Object[] array = new Object[n];
		array = result.toArray(array);

		return result;
	}
	
	@SafeVarargs
	public static final <T> T[] repeat(int n, T... objs) {
		T[] array = objs;
		int count = objs.length;
		int lenght = n;
		;
		for (int i = 0; i < n - 1; i++) {
			array = Arrays.copyOf(array, lenght);
			lenght += objs.length;
			System.out.println(Arrays.toString(array));
			for (T t : objs) {
				array[count] = t;
				count++;
			}
		}
		return array;
	}
}
