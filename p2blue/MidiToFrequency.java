/* *****************************************************************************
 *  Description:  Converts a MIDI note into its corresponding frequency.
 *
 *  Example:
 *  > java-introcs 69
 *  MIDI:        69
 *  Frequency:   440.0
 *  > java-introcs 60
 *  MIDI:        60
 *  Frequency:   261.6255653005986
 **************************************************************************** */

public class MidiToFrequency {

    // converts a given frequency, duration, and amplitude into a playable audio note
    public static double[] note(double hz, double duration, double amplitude) {
        int N = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = amplitude * Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        return a;
    }

    public static void main(String[] args) {

        // input MIDI note
        int m = Integer.parseInt(args[0]);

        // calculate the frequency of the MIDI note in hz
        double freq = ______________________;

        // print the MIDI note
        System.out.println("MIDI:        " + m);

        // print the note's frequency
        System.out.println("Frequency:   " + freq);

        // plays the given note
        StdAudio.play(note(freq, 1, 1));
    }
}
