
// An Applet skeleton.
import java.applet.Applet;
import java.awt.Graphics;

/*
<applet code="AppletSkel" width=1000 height=500>
</applet>
*/
public class appetry extends Applet {

	int a, b, sum, dif, mult, div;

// Called first.
	public void init() {
// initialization
		a = 4;
		b = 8;
	}

	/*
	 * Called second, after init(). Also called whenever the applet is restarted.
	 */
	public void start() {
// start or resume execution
		sum = a + b;
		dif = b - a;
		mult = a * b;
		div = b / a;
	}

// Called when the applet is stopped.
	public void stop() {
// suspends execution
	}

	/*
	 * Called when applet is terminated. This is the last method executed.
	 */
	public void destroy() {
// perform shutdown activities
	}

// Called when an applet’s window must be restored.
	public void paint(Graphics g) {
// redisplay contents of window
		String addr = "The sum of " + String.valueOf(b) + " & " + String.valueOf(a) + " is " + String.valueOf(sum);
		String difr = "The difference of " + String.valueOf(b) + " & " + String.valueOf(a) + " is "
				+ String.valueOf(dif);
		String multr = "The multiplication of " + String.valueOf(b) + " & " + String.valueOf(a) + " is "
				+ String.valueOf(mult);
		String divr = "The division of " + String.valueOf(b) + " & " + String.valueOf(a) + " is " + String.valueOf(div);
		g.drawString(addr, 50, 50);
		g.drawString(difr, 100, 100);
		g.drawString(multr, 150, 150);
		g.drawString(divr, 200, 200);
	}
}