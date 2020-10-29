/* *****************************************************************************
 *  Description:  Iterates through a series of MIDI notes that plays a complete
 *                octave of a chromatic scale given a root note. Also prints 
 *                each note as it plays.
 *
 *  Example:
 *  > java-introcs Chromatic 60
 *  60
 *  61
 *  62
 *  63
 *  64
 *  65
 *  66
 *  67
 *  68
 *  69
 *  70
 *  71
 *  72
 **************************************************************************** */

public class Chromatic {
    
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
        int root = ____________;

        // loops through an octave and plays each note within the scale
        for (int i = ______; ______; ______) {
            
            // Print the current note
            System.out.println(___);

            // Plays the current MIDI note i
            StdAudio.play(note(midiToFreq(i), 0.75, 1));
        }
    }
}
