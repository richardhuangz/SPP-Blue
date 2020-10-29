/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description: Reads an image from a file, flips it vertically, horizontally,
 * and both vertically & horizontally. 
 *
 * Displays: three modified images and original image.
 *
 **************************************************************************** */


import java.awt.Color;

public class ImageFlipper {
    
    // returns a Picture where each pixel is mirrored horizontally
    // does not modify input Picture
    // Lecture Using Data Types pp 28-31
    public static Picture flipH(Picture source) {
        
        // create new Picture object - don't modify source
        int width  = source.width();
        int height = source.height();
        Picture target = new Picture(width, height);
        
        // transpose EACH pixel around the horizontal axis
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the pixel
                Color pixel = source.get(col, row);
                // now set the pixel at the position flipped around horizontal
                target.set(col, height - row - 1, ______); 
            }
        }
        
        // all done
        return ______;
    }
    
    
    // returns a Picture where each pixel is mirrored vertically
    // does not modify input Picture
    public static Picture flipV(___________) {
         // create new Picture object - don't modify source
         ____________;
         ____________;
         ____________;
        
        // transpose EACH pixel around the vertical axis
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                // get the pixel
                Color pixel = source.get(col, row);
                // now set the pixel at the position flipped around vertically
                target.set(______, ______, ______); 
            }
        }
        
        // all done
        return ______;
        
    }
    
    // First command line argument contains name of file containing Picture,
    // then displays four images:
    // 1. Horizontally flipped.
    // 2. Vertically flipped.
    // 3. Flipped in both directions.
    // 4. Original image.
    public static void main(String[] args) {
        // create original Picture object from filename on command line
        Picture original = new Picture(args[0]);
        
        // refers to flipped Picture
        Picture flipped;
        
        // flip the original Picture on the horizontal and show the result
        flipped = flipH(original);
        flipped.show();
        
        // flip the original Picture on the vertical and show the result
        ________ = flipV(_________);
        ________.show();
        
        // flip horizontal and then vertical
        flipped = __________________;
        flipped.show();
        
        // show the original to demonstrate that it wasn't mutated
        original.show();
    }  
}
