import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;

public class Triangle {

	int topPoint;
	int leftPoint;
	int rightPoint;
	Color color;

	public Triangle(int topPoint, int leftPoint, int rightPoint, Color color) {
		this.topPoint = topPoint;
		this.leftPoint = leftPoint;
		this.rightPoint = rightPoint;
		this.color = color;
	}

	// public void draw(Graphics g) {
	// 	g.setColor(this.color);

	// 	Polygon poly = new Polygon();

	// 	poly.addPoint(this.leftPoint.getX(), this.leftPoint.getY());
	// 	poly.addPoint(this.rightPoint.getX(), this.rightPoint.getY());
	// 	poly.addPoint(this.topPoint.getX(), this.topPoint.getY());

	// 	g.fillPolygon(poly);
	// }
}