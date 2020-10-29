/* ***************************************************************************** 
 * Description: Takes an array of ints and prints the contents of the array.
 *              Also draws campbell cans based on which cans the ints refer to.
 *
 * Example:
 * > java-introcs CampbellCans 0 1 2 3 4 5 6 7
 * > 0 1 2 3 4 5 6 7
 **************************************************************************** */
 
public class CampbellCans {

    public static void draw(int camp, int index, int length) {
        String pic = "";
        if (camp == 0) pic = "campbell0.png";
        else if (camp == 1) pic = "campbell1.png";
        else if (camp == 2) pic = "campbell2.png";
        else if (camp == 3) pic = "campbell3.png";
        else if (camp == 4) pic = "campbell4.png";
        else if (camp == 5) pic = "campbell5.png";
        else if (camp == 6) pic = "campbell6.png";
        else if (camp == 7) pic = "campbell7.png";

        if (length % 2 != 0) length++;
        double x = (1 + (2 * (index % (length / 2.0)))) / (double) length;
        double y;
        if (index < length / 2) y = 0.75;
        else y = 0.25;

        StdDraw.picture(x, y, pic, 1.0 / (length / 2.0), 0.5);
    }

    public static void main(String[] args) {
 
        // takes the length of args[]
        int n = ________________________;

        // print in order
        for (________________________) {
            System.out.print(____________ + " ");

            // draw the can at i
            draw(Integer.parseInt(args[i]), i, n);  // don't worry about this
        }
    }
}
