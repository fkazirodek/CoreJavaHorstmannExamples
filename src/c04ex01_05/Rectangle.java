package c04ex01_05;

public class Rectangle extends Shape {

	private Point topLeft;
	private double width;
	private double height;

	public Rectangle(Point topLeft, double width, double height) {
		this.topLeft = topLeft;
		this.width = width;
		this.height = height;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public Point getCenter() {
		return new Point(width / 2, height / 2);
	}
	
	@Override
	protected Rectangle clone() throws CloneNotSupportedException {
		return new Rectangle(topLeft.clone(), width, height);
	}

}
