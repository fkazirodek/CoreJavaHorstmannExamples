package c04ex01_05;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Rectangle r = new Rectangle(new Point(4, 4), 4, 4);
		Rectangle clone = r.clone();
		System.out.println(r.getClass() == clone.getClass());
		System.out.println(clone.equals(r));
		System.out.println(clone == r); // false if references point to other objects

	}

}
