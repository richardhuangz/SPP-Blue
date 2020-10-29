/* *****************************************************************************
 *  Description:  This class can perform a basic chromakeying operation on
 *                a Picture variable.
 *
 * Example:
 * > java-introcs Photoshop
 **************************************************************************** */

public class Photoshop {

    private Picture pic;        // the picture we'll be editing
    private int width;         // width of pic
    private int height;       // height of pic

    // constructs a Photoshop object given an input picture
    public Photoshop(Picture input) {
        pic = new Picture(input);
        width = pic.width();
        height = pic.height();
    }

    // keys out a green screen and replaces it with the pixels from the input
    // background picture with a fixed threshold (200)
    public Picture edit(Picture background) {
        if (background.width() < pic.width() || background.height() < pic.height()) {
            throw new IllegalArgumentException("Background photo is unusable, too small");
        }

        // initialize new edited picture
        Picture shop = new Picture(width, height);
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                // if the pixel at (col, row) has a green value of over 200, replace it
                // with the background; otherwise keep it the same as pic
                if (pic.get(col, row).getGreen() > 200) {
                    shop.set(col, row, background.get(col, row));
                }
                else {
                    shop.set(col, row, pic.get(col, row));
                }
            }
        }
        return shop;
    }

    public static void main(String[] args) {
        Photoshop ph = new Photoshop(null);
        
    }
