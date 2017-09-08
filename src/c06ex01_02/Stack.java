package c06ex01_02;

import java.util.ArrayList;

public class Stack<E> {

	private ArrayList<E> list = new ArrayList<>();
	
	public ArrayList<E> getList() {
		return list;
	}

	public void push(E e) {
		list.add(e);
	}
	
	public void pop(E e) {
		list.remove(e);
	}
	
	public boolean isEmpty(ArrayList<E> list) {
		return (list != null && list.size() == 0) ? true : false;
	}
}
