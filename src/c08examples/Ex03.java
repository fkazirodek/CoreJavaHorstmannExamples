package c08examples;


import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03 {

	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		
		Stream<int[]> stream = Stream.of(values);
		IntStream intStream = Arrays.stream(values);
		
	}

}
