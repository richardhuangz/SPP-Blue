/* *****************************************************************************
 *  Description:  Play a random note within an octave in the chromatic scale 
 *                given a root note.
 *
 *  Example:
 *  > java-introcs 60
 *  67
 *  > java-introcs 72
 *  72
 **************************************************************************** */

public class RandomNote {
   
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

        // fixed number of notes to choose from 
        ___ NUM_NOTES = ___;

        // input root note
        int root = Integer.parseInt(args[0]);

        // choose a random MIDI note within an octave above the root
        int rand = _____________;
        System.out.println(rand);

        // Plays the note
        StdAudio.play(note(midiToFreq(rand), 1, 1));
    }
}
