package c03ex08_09;

public class Greeter_Main {

	public static void main(String[] args) {
		Greeter g1 = new Greeter(100, "świecie");
		Greeter g2 = new Greeter(100, "Filip");
		Greeter.runTogether(g1, g2);
		Greeter.runInOrder(g1, g2);

	}
}
