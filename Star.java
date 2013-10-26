import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;

public class Star {

	private double diameter;
	private Point leftPoint;
	private Point[] points;
	private Color color;
	Pentagon outerPentagon;
	Pentagon innerPentagon;
	private double centerYOffsetRatio = 0.109;
	private double centerXOffsetRatio = 0.478;

	public Star(double diameter, Point centerPoint, Color color) {
		this.diameter = diameter;
		this.leftPoint = new Point((int)(centerPoint.getX() - (this.diameter * this.centerXOffsetRatio)), (int)(centerPoint.getY() - (this.diameter *this.centerYOffsetRatio))); 
		this.points = new Point[10];
		this.color = color;

		this.generatePoints();
	}

	public void generatePoints() {
		outerPentagon = new Pentagon(this.leftPoint, this.diameter, this.color, false);
		Point p = new Point(this.leftPoint.getX() + (int)(this.diameter / 3.34), this.leftPoint.getY() + (int)((this.diameter) / 4));
		innerPentagon = new Pentagon(p, this.diameter / 2.34, Color.BLACK, true);
		Point[] outerPoints = outerPentagon.getClockwisePointConfig(false);
		Point[] innerPoints = innerPentagon.getClockwisePointConfig(true);

		int index = 0;

		for (int i = 0 ; i < 5 ; i++) {
			this.points[index] = outerPoints[i];
			index++;
			this.points[index] = innerPoints[i];
			index++;
		}
	}

	public void draw(Graphics g) {
		g.setColor(this.color);
		Polygon poly = new Polygon();

		for (int i = 0 ; i < 10 ; i++) {
			poly.addPoint(this.points[i].getX(), this.points[i].getY());
		}

		g.fillPolygon(poly);

		//outerPentagon.draw(g);
		//innerPentagon.draw(g);
	}
}