/* *****************************************************************************
 *  Description:  Plays a series of MIDI notes from StdIn and prints the 
 *                highest and lowest pitches.
 *
 * Example:
 * > java-introcs MaxMinMIDI < twinkleMIDI.txt
 *  Max note is 69
 *  Min note is 60
 * > java-introcs MaxMinMIDI < maryMIDI.txt
 *  Max note is 67
 *  Min note is 60
 **************************************************************************** */

public class MaxMinMIDI {

    // create a note (sine wave) of the given frequency (Hz), for the given
    // duration (seconds) scaled to the given volume (amplitude)
    private static double[] note(double hz, double duration, double amplitude) {
        int N = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = amplitude * Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        return a;
    }

    // converts a midi value to the corresponding frequency
    private static double midiToFreq(int note) {
        return (Math.pow(2, ((note - 69) / 12.0))) * 440;
    }

    public static void main(String[] args) {

        // read duration of the first note
        double dur = StdIn.readDouble();

        // read the MIDI value of the first note and initialize min and max
        int max = _________;
        int min = _________;

        // play the first note
        StdAudio.play(note(midiToFreq(max), dur, 1));

        // read in the data, keep track of min and max
        while (_________) {

            // read the note's duration
            dur = StdIn.readDouble();

            // read the MIDI value
            int value = _________;

            // update max and/or min if necessary
            __________________;
            __________________;

            // play the note
            StdAudio.play(note(midiToFreq(value), dur, 1));
        }
        System.out.println("Max note is " + max);
        System.out.println("Min note is " + min);
    }
}
