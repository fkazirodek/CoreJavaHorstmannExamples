package c06ex07_11;

public class Pair<E extends Comparable<E>> {

	private E first;
	private E second;
	
	public Pair() {
	}

	public Pair(E first, E second) {
		this.first = first;
		this.second = second;
	}

	public E getFirst() {
		return first;
	}
	public E getSecond() {
		return second;
	}
	
	// x.compareTo(y) 
	// x > y -> 1
	// x = y -> 0
	public E max() {
		return first.compareTo(second) > 0 ? first : second;
	}
	
	public E min() {
		return first.compareTo(second) < 0 ? first : second;
	}

	@Override
	public String toString() {
		return "[first=" + first + ", second=" + second + "]";
	}
	
	
}
