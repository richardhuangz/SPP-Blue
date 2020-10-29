/* *****************************************************************************
 *  Description:  Plays a melody of notes represented in scientific pitch 
 *                notation using parallel arrays to store data. 
 *
 * Example:
 * > java-introcs Melody < twinkle.txt
 * > java-introcs Melody < mary.txt
 **************************************************************************** */

public class Melody {

    public static void main(String[] args) {

        // read the number of notes in the melody
        int n = _________;

        // declare and initialize four parallel arrays
        double[] durations = ____________;
        char[] pitches = ____________;
        int[] octaves = ____________;
        int[] accidentals = ____________;

        // read StdIn and assign values into each array
        for (int i = 0; i < n; i++) {
            durations[i] = _________;
            StdIn.readChar();               
            pitches[i] = _________;
            octaves[i] = _________;
            accidentals[i] = _________;
        }

        // play the melody
        for (int i = 0; i < n; i++) {
            StdAudio2.play(durations[i], pitches[i], octaves[i], accidentals[i]);
        }
    }
}
