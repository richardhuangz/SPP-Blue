/* *****************************************************************************
 *  Description:  Draws a piece of art based on Piet Mondrian's cubism paintings.
 *
 *  Example:
 *  > java-introcs Mondrian
 **************************************************************************** */

public class Mondrian {

    private static final double MIN_AREA = 0.01;

    public static void draw(double x, double y, double width, double height) {
        if (____________) {         // base case
            if (____________) {    // horizontal or vertical line?
                double rand = StdRandom.uniform(0, width);
                StdDraw.line(____________);     // vertical line
                draw(____________);            // move to the left side of the line
                draw(____________);           // move to the right side of the line
            }
            else {
                double rand = StdRandom.uniform(0, height);
                StdDraw.line(____________);     // horizontal line
                draw(____________);            // move to the lower side of the line
                draw(____________);           // move to the upper side of the line
            }
        }
    }

    public static void main(String[] args) {
        draw(0, 0, 1, 1);
    }
}
