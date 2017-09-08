package c03ex13;

public class Runnable_Main {

	public static void main(String[] args) {
		Car_Runnable[] cars = new Car_Runnable[3];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car_Runnable();
		}
		getRunnable(cars).run();;
		

	}

	private static Runnable getRunnable(Runnable...runnables) {
		return () -> {
			for (Runnable runnable : runnables) {
				runnable.run();
			}
		};
	}
}
