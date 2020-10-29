/* *****************************************************************************
 *  Description:  Animates the stepping feet illusion.
 *
 * Example
 * > java-introcs SteppingFeet
 **************************************************************************** */

import java.awt.Color;

public class SteppingFeet {
    public static void main(String[] args) {

        // number of background bars
        int bars = 24;

        // makes the animation smoother
        StdDraw.enableDoubleBuffering();

        // initial position, velocity, and width of the rectangles
        double x = 0.25;
        double vx = 0.005;
        double width = 0.125;

        // main animation loop
        while (true) {

            // "bounce" rectangle off the edge if it hits the edge
            if (x + width + vx > 1 || Math.abs(x + vx) - width < 0) vx = -vx;

            // update x position of rectangle (y position will always be the same)
            x += vx;

            // clear the canvas with a black background
            StdDraw.clear(Color.BLACK);

            // draw the gray bars
            for (int i = 1; i <= bars; i += 2) {
                StdDraw.setPenColor(Color.LIGHT_GRAY);
                StdDraw.filledRectangle((1.0 / bars * i) - (1.0 / (bars * 2)), 0.5,
                                        1.0 / (bars * 2),
                                        0.5);
            }

            // draw the rectangles
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.filledRectangle(x, 0.7, width, width / 2);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledRectangle(x, 0.3, width, width / 2);

            // display and pause for 20 ms
            StdDraw.show();  // double buffer is enabled
            StdDraw.pause(20);
        }
    }
}
