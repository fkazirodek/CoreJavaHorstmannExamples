package c03ex01_02;

public class Employee implements Measurable {

	private String name;
	private double salary;

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Employee(String name) {
		this(name, 0);
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public double getMeasure() {
		return this.salary;
	}

	@Override
	public double average(Measurable[] objects) {
		double sum = 0;
		int count = 0;
		for (Measurable m : objects) {
			sum += m.getMeasure();
			count++;
		}
		return sum / count;
	}

	@Override
	public Measurable largest(Measurable[] objects) {
		double largest = objects[0].getMeasure();
		Measurable measurable = objects[0];
		for (Measurable m : objects) {
			if (m.getMeasure() > largest) {
				largest = m.getMeasure();
				measurable =  m;
			}
		}
		return (Employee) measurable;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

}
