package c03ex13;

public class Car_Runnable implements Runnable{

	private static final int DEFAULT_TANK_CAPCITY = 50;
	private static final int DEFAULT_FUEL_CONSUMPTION = 8;

	private double fuel;
	private final int tankCapacity;
	// fuel consumption l/100km
	private double fuelConsumption;
	// Total traveled distance
	private double totalDistance;

	public Car_Runnable() {
		tankCapacity = DEFAULT_TANK_CAPCITY;
		fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
		fuel = 10;
	}

	public Car_Runnable(int tankCapacity, double fuelConsumption) {
		this.tankCapacity = tankCapacity;
		this.fuelConsumption = fuelConsumption;
	}

	public double getFuel() {
		return fuel;
	}

	public void refuel(int fuelQuantity) {
		System.out.println("Tankowanie...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (fuel + fuelQuantity < tankCapacity) {
			this.fuel += fuelQuantity;
		} else {
			this.fuel = tankCapacity;
		}
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(int fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public double getDistance() {
		return totalDistance;
	}

	public void setDistance(int distance) {
		this.totalDistance = distance;
	}

	public int getTankCapacity() {
		return tankCapacity;
	}

	public void drive(double distance) {
		totalDistance = distance;
		for (int i = 1; i <= totalDistance; i++) {
			fuel -= fuelConsumption / 100;
			String fuel_format = String.format("%.2f", fuel);
			distance--;
			if (fuel == 0) {
				System.out.println("Brak paliwa w baku");
				return;
			}
			System.out.println("Przejechałeś " + (totalDistance - distance) + " km, pozostało do przejechania " + distance
					+ ". Pozosatało " + fuel_format + " l benzyny");
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		drive(10);
		refuel(10);
		drive(10);
	}

}
