package c06ex01_02;

import java.util.Arrays;
import java.util.function.Supplier;

public class Stack_Array<E> {

	private E[] array;

	public E[] getArray() {
		return array;
	}

	public void setArray(Supplier<E[]> sup) {
		this.array = sup.get();
	}

	public void push(int index, E e) {
		if (index == array.length) {
			this.array = Arrays.copyOf(array, array.length + 1);;
		}
		this.array[index] = e;
	}

	public void pop(int index) {
		array[index] = null;
		for (int i = index; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length-1] = null;
	}
}
