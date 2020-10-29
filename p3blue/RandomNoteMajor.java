/* *****************************************************************************
 *  Description:  Prints and plays a random note within an octave of the 
 *                chromatic scale given a input root note. Will also print 
 *                whether or not the random note is in the root note's major
 *                scale or not.
 *
 *  Example:
 *  > java-introcs RandomNoteMajor 60
 *  60 is in major scale!
 *  > java-introcs RandomNoteMajor 60
 *  61 is not in major scale
 **************************************************************************** */

public class RandomNoteMajor {

    // converts a given frequency, duration, and amplitude into a playable audio note
    private static double[] note(double hz, double duration, double amplitude) {
        int N = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = amplitude * Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        return a;
    }

    // Converts a midi value to the corresponding frequency
    public static double midiToFreq(int note) {
        return (Math.pow(2, ((note - 69) / 12.0))) * 440;
    }
    
    public static void main(String[] args) {

        // input root note
        int root = Integer.parseInt(args[0]);

        // choose a random note within an octave above the root
        int rand = (int) (Math.random() * 13 + root);

        // calculate the distance between note and root
        int interval = ____________;

        // is the note in the major scale or not?
        if (________________) {
            System.out.println(rand + " is not in major scale");
        }
        else {
            System.out.println(rand + " is in major scale!");

            // Plays the note
            StdAudio.play(note(midiToFreq(rand), 1, 1));
        }
    }
}
