import java.awt.Color;
import java.awt.Graphics;

public class AmericanFlag {

	private double width;
	private double height;
	private Rectangle[] stripes;
	private Rectangle union;
	private Star[] stars;

	private double unionHeightRatio = 7.0 / 13.0;
	private double unionWidthRatio = 0.76;
	private double stripeHeightRatio = 1.0 / 13.0;
	private double stripeWidthRatio = 0.24;
	private double starDiameterRatio = 0.0616;
	private double starHorizSpacingRatio = 0.063;
	private double starVertSpacingRatio = 0.054;

	public AmericanFlag(double width, double height, double scale) {
		this.width = width * scale;
		this.height = height * scale;
		this.stripes = new Rectangle[13];
		this.stars = new Stars[50];

		int uWidth = (int)(this.unionWidthRatio * this.height);
		int uHeight = ((int)(this.stripeHeightRatio * this.height)) * 7;
		this.union = new Rectangle(uWidth, uHeight, new Point(0, 0), Color.BLUE);

		int stripeHeight = (int)(this.stripeHeightRatio * this.height);

		int yOffset = 0;

		for (int i = 0 ; i < this.stripes.length ; i++) {
			if (i % 2 == 0) {
				this.stripes[i] = new Rectangle((int)this.width, stripeHeight, new Point(0, yOffset), Color.RED);
			} else {
				this.stripes[i] = new Rectangle((int)this.width, stripeHeight, new Point(0, yOffset), Color.WHITE);
			}

			yOffset += stripeHeight;
		}
	}


	public void draw(Graphics g) {
		for (int i = 0 ; i < 13 ; i++) {
			this.stripes[i].draw(g);
		}
		this.union.draw(g);
	}

}