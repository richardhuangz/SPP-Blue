/* *****************************************************************************
 * Description: Randomly draws cans until a repeat can is chosen. Also prints
 *              the resulting the cans as their corresponding ints.
 *
 *  Example:
 *  > java-introcs RandomCans
 *  0 3 5
 **************************************************************************** */
 
 public class RandomCans {

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

        // constant number of soup cans
        int CANS = ______;

        // stores the cans that we will randomly generate, set its length
        // to equal CANS because we can assume its length won't exceed CANS
        int[] cans = ____________;

        // this array will associate true or false with each possible can
        boolean[] seenBefore = ____________;

        // this counter variable will be used
        int counter = 0;

        while (______) { // same as: while (1 < 2)

            // represented as a random int between 0 and 7
            int can = ____________;

            // if we've seen this can in a previous iteration,
            // leave the loop immediately
            if (____________)
                break;

            // sets the value at index counter to equal can
            cans[counter] = can;

            // update seenBefore[], for future iterations of this loop
            __________________;

            // increment counter
            counter++;
        }

        // print and draw each can in cans[]
        for (________________________) {
            System.out.println(______);
            draw(cans[i], i, counter);  // don't worry about this
        }
     }
 }
