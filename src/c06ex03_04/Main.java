package c06ex03_04;


public class Main {

	public static void main(String[] args) {
		Entry<Integer, String> e1 = new Entry<>(1, "AAA");
		Entry<Integer, String> e2 = new Entry<>(2, "BBB");
		Entry<Integer, String> e3 = new Entry<>(3, "CCC");
		Entry<Integer, String> e4 = new Entry<>(4, "DDD");
		Table<Integer, String> t = new Table<>();
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		System.out.println(t.getValue(1));
		System.out.println(t.getListEntry());
		t.remove(1);
		t.setValue("This is a new value", 2);
		System.out.println(t.getListEntry());
	}

}
