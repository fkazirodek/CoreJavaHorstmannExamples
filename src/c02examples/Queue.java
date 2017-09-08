package c02examples;

public class Queue {

	private Node first;
	private Node last;

	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	/**
	 * Add element to list on the end
	 * @param text String
	 */
	public void add(String text) {
		Node node = new Node(text, null, null);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			last.setNext(node);
			node.setPrevious(last);
			last = node;
		}
	}

	/**
	 * Remove first element from list
	 */
	public void remove() {
		first = first.getNext();
		first.setPrevious(null);
	}

	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * This method returned new Iterator()
	 * @return Iterator
	 */
	public Iterator iterator() {
		return new Queue.Iterator();
	}

	class Node {

		private String text;
		private Node next;
		private Node previous;

		public Node() {
		}

		public Node(String text, Node next, Node previous) {
			this.text = text;
			this.next = next;
			this.previous = previous;
		}

		public String getText() {
			return text;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		@Override
		public String toString() {
			return text;
		}
	}

	class Iterator {

		private Node element = null;
		private Node next = first; 

		/**
		 * This method returned next element in queue
		 * @return next String
		 */
		public Node next() {
			if (element == null) {
				element = first;
				return element;
			}
			element = element.getNext();
			next = element;
			return element;
		}

		public boolean hasNext() {
			return next.getNext() != null ? true : false;
		}

	}

}
