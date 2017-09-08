package c04ex01_05;

public abstract class Shape implements Cloneable {

	double x;
	double y;

	public Shape() {}

	public void moveBy(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public abstract Point getCenter();

}
