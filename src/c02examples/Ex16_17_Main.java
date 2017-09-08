package c02examples;

import c02examples.Queue.Iterator;

public class Ex16_17_Main {

	public static void main(String[] args) {
		Queue queue = new Queue();
		System.out.println(queue.isEmpty());
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		queue.add("f");
		queue.add("g");
		queue.add("h");
		System.out.println("first = " + queue.getFirst());
		System.out.println("last = " + queue.getLast());
		queue.remove();
		System.out.println("first after remove = " + queue.getFirst());
		
		Iterator iterator = queue.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
