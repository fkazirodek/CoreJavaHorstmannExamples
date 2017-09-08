package c06ex01_02;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Stack_Array<Integer> stack = new Stack_Array<>();
		stack.setArray(() -> new Integer[10]);

		for (int i = 0; i < 20; i++) {
			stack.push(i, i);
		}
		System.out.println(Arrays.toString(stack.getArray()));

		stack.pop(5);
		System.out.println(Arrays.toString(stack.getArray()));
	}

}
