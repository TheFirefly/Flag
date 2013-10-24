import java.awt.Color;
import java.awt.Polygon;

public class Star {

	private int diameter;
	private Point topPoint;
	private Color color;

	public Star(int diameter, Point topPoint, Color color) {
		this.diameter = diameter;
		this.topPoint = topPoint;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(this.color);

		Polygon poly = new Polygon();

		poly.addPoint(topPoint.getX(), topPoint.getY());
	}
}