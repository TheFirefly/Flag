import java.awt.Color;
import java.awt.Graphics;

public class AmericanFlag {

	private double width;
	private double height;
	private Rectangle[] stripes;
	private Rectangle union;

	private double unionHeightRatio = 7.0 / 13.0;
	private double unionWidthRatio = 0.76;
	private double stripeHeightRatio = 1.0 / 13.0;
	private double stripeWidthRatio = 0.24;

	public AmericanFlag(double width, double height, double scale) {
		this.width = width * scale;
		this.height = height * scale;
		this.stripes = new Rectangle[13];

		int uWidth = (int)(this.unionWidthRatio * this.height);
		int uHeight = ((int)(this.stripeHeightRatio * this.height)) * 7;
		this.union = new Rectangle(uWidth, uHeight, Color.BLUE);

		int stripeHeight = (int)(this.stripeHeightRatio * this.height);

		for (int i = 0 ; i < 13 ; i++) {
			if (i % 2 == 0) {
				this.stripes[i] = new Rectangle((int)this.width, stripeHeight, Color.RED);
			} else {
				this.stripes[i] = new Rectangle((int)this.width, stripeHeight, Color.WHITE);
			}
		}
	}


	public void draw(Graphics g) {
		int yLoc = 0;
		for (int i = 0 ; i < 13 ; i++) {
			if (i > 0) {
				yLoc += this.stripes[i].getHeight();
			}
			this.stripes[i].draw(g, yLoc);
		}
		this.union.draw(g, 0);
	}

}