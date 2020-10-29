/* *****************************************************************************
 *  Description:  Draws a piece of art based on Sol Lewitt's artwork using 
 *                multiple functions.
 *  
 *  Example:
 *  > java-introcs SolLewitt
 **************************************************************************** */

import java.awt.Color;

public class SolLewitt {
    
    // Return the corresponding Color
    public static Color getColor(char color) {
        if (color == 'R') return Color.RED;
        else if (color == 'O') return Color.ORANGE;
        else if (color == 'Y') return Color.YELLOW;
        else if (color == 'G') return Color.GREEN;
        else if (color == 'B') return Color.BLUE;
        else if (color == 'I') return new Color(75, 0, 130);    // INDIGO
        else return new Color(238, 130, 238);                  // VIOLET
    }

    public static void backgroundColors(String colors) {

        // number of rectangles, or length of colors
        int n = _________;

        // draw rectangles
        for (int i = 0; i < n; i++) {

            // set the color based on the String colors
            StdDraw.setPenColor(getColor(_________));
            StdDraw.filledRectangle((1.0 / n * (i + 1)) - (1.0 / (n * 2)), 0.5, 1.0 / (n * 2), 0.5);
        }
    }

    public static void backgroundColors(char[] colors) {

        // number of rectangles, or length of colors
        int n = _________;
        StdDraw.setScale(0, 1);

        // draw rectangles
        for (int i = 0; i < n; i++) {

            // set the color based on the array colors
            StdDraw.setPenColor(getColor(_________));
            StdDraw.filledRectangle((1.0 / n * (i + 1)) - (1.0 / (n * 2)), 0.5, 1.0 / (n * 2), 0.5);
        }
    }

    public static void main(String[] args) {
        backgroundColors("ROYG");
        backgroundColors(new char[] {'R', 'O', 'Y', 'G'});
    }
}   
