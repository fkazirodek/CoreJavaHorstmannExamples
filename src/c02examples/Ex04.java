package c02examples;

import org.omg.CORBA.IntHolder;

public class Ex04 {

	public static void main(String[] args) {
		int x = 1;
		int y = add(x, 4);
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		IntHolder intHolder = new IntHolder(1);
		add(intHolder, 5);
		System.out.println("intHolder = " + intHolder.value);

		Integer i = 4;
		Integer j = add(i, 4);
		System.out.println("Integer i = " + i);
		System.out.println("Integer j = " + j);

	}

	private static int add(int x, int value) {
		x += value;
		return x;
	}

	private static void add(IntHolder x, int y) {
		x.value += y;
	}

	private static Integer add(Integer x, int y) {
		return x += y;
	}
}
