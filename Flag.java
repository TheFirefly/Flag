import java.awt.*;
import java.applet.*;

public class Flag extends Applet {
	
	private AmericanFlag flag;

	public void init() {
		flag = new AmericanFlag(1900, 1000, 0.75);
	}

	public void paint(Graphics g) {
		flag.draw(g);
	}

}