import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {

	private int width;
	private int height;
	private Point topLeft;
	private Color color;

	public Rectangle(int width, int height, Point topLeft, Color color) {
		this.width = width;
		this.height = height;
		this.topLeft = topLeft;
		this.color = color;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(this.topLeft.getX(), this.topLeft.getY(), this.width, this.height);
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
}