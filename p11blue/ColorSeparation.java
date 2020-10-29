/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads an image from a file, and displays the red, green,
 *              and blue components in three separate windows.   
 * 
 * Remark: This is Booksite Creative Exercise 3.1.60.
 *
 **************************************************************************** */

import java.awt.Color;

public class ColorSeparation {
   public static void main(String[] args) {

      // read the picture specified by command-line argument
      Picture picture = new Picture(args[0]);
      int width  = picture.width();
      int height = picture.height();

      // create three empty pictures of the same dimension
      Picture pictureR = new Picture(width, height);  // R
      Picture pictureG = __________________________;  // G
      _____________________________________________;  // B

      // separate colors
      for (int col = 0; col < width; col++) {
         for (int row = 0; row < height; row++) {

            // color value of current pixel
            Color color = picture.____________________;
                                              
            int r = color.getRed();  // r
            int g = ______________;  // g
            ______________________;  // b

            pictureR.set(col, row, new Color(r, 0, 0)); 
            __________________________________________;
            __________________________________________;
         }
      }

      // display each picture in its own window
      pictureR.show();
      _______________;
      _______________;
   }  
}
