/* *****************************************************************************
 *  Description: The top and bottom bars each contain the same component 
 *               colors, but a different display order causes individual 
 *               colors to appear differently.
 *
 * Example
 * > java-introcs Relativity 100
 **************************************************************************** */

import java.awt.Color;

public class Relativity {

    public static void main(String[] args) {

        // input number of rectangles on each half of the canvas
        int n = Integer.parseInt(args[0]);

        // set of colors for the rectangles
        Color a = new Color(165, 167, 20);
        Color b = new Color(77, 86, 59);
        Color c = new Color(42, 106, 105);
        Color d = new Color(165, 89, 20);
        Color e = new Color(146, 150, 127);
        Color[] colors = { a, b, c, d, e };

        // draw the top rectangles
        for (____________) {

            // choose a color (not randomly)
            StdDraw.setPenColor(colors[i % 5]);

            // draw a rectangle with this color
            StdDraw.filledRectangle(____________, ____________, ____________, ____________);
        }

        // reorder the original set of colors
        Color[] reorder = { c, a, d, b, e };

        // draw the bottom rectangles
        for (____________) {

            // choose a color (not randomly)
            StdDraw.setPenColor(reorder[i % 5]);

            // draw a rectangle with this color
            StdDraw.filledRectangle(____________, ____________, ____________, ____________);
        }

        // show canvas
        StdDraw.show();
    }
}
