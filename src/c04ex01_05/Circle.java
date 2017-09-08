package c04ex01_05;

public class Circle extends Shape {

	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public Point getCenter() {
		return center;
	}
	
	@Override
	protected Circle clone() throws CloneNotSupportedException {
		return new Circle(center.clone(), radius);
	}

}
