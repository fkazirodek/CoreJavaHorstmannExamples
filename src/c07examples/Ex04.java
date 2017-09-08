package c07examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex04 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		remove(list); 
		//we can use removeIf or removeAll
		
		System.out.println(list);
		
	}


	public static <E> void remove(List<E> list) {
		Iterator<E> it = list.iterator();
		while (it.hasNext()) {
			//list.remove(it.next()); //does not work becouse of ConcurrentModificationException
			
			//resolve the problem
			it.next();
			it.remove();
			
		}
	}

}
