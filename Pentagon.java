import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;

public class Pentagon {

	private Point leftPoint;
	private double diameter;
	private Point rightPoint;
	private Point bottomLeftPoint;
	private Point bottomRightPoint;
	private Point topPoint;
	private double sideLength;
	private Color color;

	public Pentagon(Point leftPoint, double diameter, Color color, boolean flipped) {
		this.color = color;
		this.leftPoint = leftPoint;
		this.diameter = diameter;
		this.rightPoint = new Point(this.leftPoint.getX() + (int)(this.diameter), this.leftPoint.getY());
		this.sideLength = diameter * 0.616;

		double bottomXOffset = (diameter - sideLength) / 2.0;

		double yOffsetDown = Math.pow(sideLength, 2.0) - Math.pow(bottomXOffset, 2.0);
		yOffsetDown = Math.sqrt(yOffsetDown);

		double yOffsetUp = Math.pow(sideLength, 2.0) - Math.pow((diameter / 2.0), 2.0);
		yOffsetUp = Math.sqrt(yOffsetUp);

		if (!flipped) {
			this.bottomLeftPoint = new Point(this.leftPoint.getX() + ((int)((this.diameter - (this.sideLength)) / 2.0)), this.leftPoint.getY() + (int)yOffsetDown);
			this.bottomRightPoint = new Point(this.bottomLeftPoint.getX() + (int)this.sideLength, this.bottomLeftPoint.getY());
			this.topPoint = new Point(this.leftPoint.getX() + (int)(this.diameter / 2.0), this.leftPoint.getY() - (int)yOffsetUp);
		} else {
			this.bottomLeftPoint = new Point(this.leftPoint.getX() + ((int)((this.diameter - (this.sideLength)) / 2.0)), this.leftPoint.getY() - (int)yOffsetDown);
			this.bottomRightPoint = new Point(this.bottomLeftPoint.getX() + (int)this.sideLength, this.bottomLeftPoint.getY());
			this.topPoint = new Point(this.leftPoint.getX() + (int)(this.diameter / 2.0), this.leftPoint.getY() + (int)yOffsetUp);
		}

	}

	public void draw(Graphics g) {
		g.setColor(this.color);

		Polygon poly = new Polygon();

		poly.addPoint(topPoint.getX(), topPoint.getY());
		poly.addPoint(rightPoint.getX(), rightPoint.getY());
		poly.addPoint(bottomRightPoint.getX(), bottomRightPoint.getY());
		poly.addPoint(bottomLeftPoint.getX(), bottomLeftPoint.getY());
		poly.addPoint(leftPoint.getX(), leftPoint.getY());


		g.fillPolygon(poly);
	}

	public Point[] getClockwisePointConfig(boolean flipped) {
		Point[] points = new Point[5];

		if (!flipped) {
			points[0] = this.leftPoint;
			points[1] = this.topPoint;
			points[2] = this.rightPoint;
			points[3] = this.bottomRightPoint;
			points[4] = this.bottomLeftPoint;
		} else {
			points[0] = this.bottomLeftPoint;
			points[1] = this.bottomRightPoint;
			points[2] = this.rightPoint;
			points[3] = this.topPoint;
			points[4] = this.leftPoint;
		}

		return points;
	}

}