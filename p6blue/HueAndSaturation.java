/* *****************************************************************************
 *  Description:  Simulates n amount of bouncing balls (like 
 *                BouncingBallsDeluxe.java). The x value of a ball corresponds
 *                to its hue value while the y value corresponds to its 
 *                saturation value.
 *
 *  Example:
 *  > java-introcs HueAndSaturation 1000
 *  > java-introcs HueAndSaturation 100
 *  > java-introcs HueAndSaturation 10
 **************************************************************************** */

import java.awt.Color;

public class HueAndSaturation {

    public static void main(String[] args) {
        
        // parse n (the number of balls to animate) from the command-line
        int n = __________________;

        // initial positions for n balls (origin)
        double[] rx = __________________;
        double[] ry = __________________;

        // colors of n balls
        Color[] colors = new Color[n];

        // initial random velocities, [-0.02, 0.02)
        double[] vx = __________________;
        double[] vy = __________________;

        // initialize random starting positions and velocities, also set color to red (just for now)
        for (int i = 0; i < n; i++) {
            rx[i] = StdRandom.uniform(0.2, 0.8);
            ry[i] = StdRandom.uniform(0.2, 0.8);
            vx[i] = StdRandom.uniform(-0.02, 0.02);
            vy[i] = StdRandom.uniform(-0.02, 0.02);
            colors[i] = Color.RED;
        }

        // radius of balls
        double radius = 0.02;

        // initialize standard drawing
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // main animation loop
        while (true) {
            for (__________________) {
                // bounce off wall according to law of elastic collision
                if (rx[i] + vx[i] + radius > 1.0 || Math.abs(rx[i] + vx[i]) - radius < 0)
                    vx[i] = -vx[i];
                if (ry[i] + vy[i] + radius > 1.0 || Math.abs(ry[i] + vy[i]) - radius < 0)
                    vy[i] = -vy[i];

                // update positions - velocity is constant
                rx[i] = rx[i] + vx[i];
                ry[i] = ry[i] + vy[i];

                // get the hue, saturation, and brightness of the color at i
                float[] hsb = Color
                        .RGBtoHSB(colors[i].getRed(), colors[i].getGreen(), colors[i].getBlue(),
                                  null);

                // set hue to equal rx[i] and saturation to equal ry[i]
                hsb[0] = (float) rx[i];
                hsb[1] = (float) ry[i];

                float hue = hsb[0];
                float saturation = hsb[1];
                float bright = hsb[2];

                // set the rgb value based on the hue, saturation, and brightness
                int rgb = Color.HSBtoRGB(hue, saturation, bright);

                // set the color at i based on the rgb value
                colors[i] = new Color(rgb);

            }

            // set the background to light gray
            __________________;

            // draw balls on the screen
            for (__________________) {
                StdDraw.setPenColor(colors[i]);
                StdDraw.filledCircle(______, ______, ______);
            }

            // display and pause for 20 ms
            __________________;  
            __________________;
        }
    }
}

