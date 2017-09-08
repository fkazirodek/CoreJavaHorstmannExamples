package c03ex08_09;

public class Greeter implements Runnable {

	private int n;
	private String target;

	public Greeter() {
	}

	public Greeter(int n, String target) {
		this.n = n;
		this.target = target;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.println("Witaj " + target);
		}
	}

	public static void runTogether(Runnable... tasks) {
		for (Runnable r : tasks) {
			Thread t = new Thread(r);
			t.start();
		}
	}

	public static void runInOrder(Runnable... tasks) {
		for (Runnable r : tasks) {
			r.run();
		}
	}
}
