package c04ex01_05;

public class Line extends Shape {

	private Point from;
	private Point to;

	public Line(Point from, Point to) {
		this.from = from;
		this.to = to;
	}

	public Point getFrom() {
		return from;
	}

	public Point getTo() {
		return to;
	}

	@Override
	public Point getCenter() {
		double xCenter = (from.x + to.x) / 2;
		double yCenter = (from.y + to.y) / 2;
		return new Point(xCenter, yCenter);
	}
	
	@Override
	protected Line clone() throws CloneNotSupportedException {
		return new Line(from.clone(), to.clone());
	}

}
