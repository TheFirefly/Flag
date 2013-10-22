import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {

	private int width;
	private int height;
	private Color color;

	public Rectangle(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public void draw(Graphics g, int yLoc) {
		g.setColor(color);
		g.fillRect(0, yLoc, this.width, this.height);
	}

	public int getHeight() {
		return this.height;
	}

	public int getWidth() {
		return this.width;
	}
}