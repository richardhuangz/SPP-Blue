/* *****************************************************************************
 *  Description:  Adaptation to StdAudio.java that accounts for pitch, duration,
 *                octave, and accidental as inputs. Not a part of the Princeton 
 *                java library.
 *
 *
 **************************************************************************** */

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * <i>Standard audio</i>. This class provides a basic capability for
 * creating, reading, and saving audio.
 * <p>
 * The audio format uses a sampling rate of 44,100 (CD quality audio), 16-bit,
 * monaural.
 *
 * <p>
 * For additional documentation, see
 * <a href="http://introcs.cs.princeton.edu/15inout"> Section 1.5</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by
 * Robert Sedgewick and Kevin Wayne.
 */
public final class StdAudio2 {

    /**
     * The sample rate - 44,100 Hz for CD quality audio.
     */
    public static final int SAMPLE_RATE = 44100;

    private static final int BYTES_PER_SAMPLE = 2;               // 16-bit audio
    private static final int BITS_PER_SAMPLE = 16;               // 16-bit audio
    private static final double MAX_16_BIT = Short.MAX_VALUE;    // 32,767
    private static final int SAMPLE_BUFFER_SIZE = 4096;


    private static SourceDataLine line;   // to play the sound
    private static byte[] buffer;         // our internal buffer
    private static int bufferSize;    // number of samples currently in internal buffer

    // not-instantiable
    private StdAudio2() {
    }


    // static initializer
    static {
        init();
    }

    // open up an audio stream
    public static void init() {
        try {
            // 44,100 samples per second, 16-bit audio, mono, signed PCM, little Endian
            AudioFormat format = new AudioFormat((float) SAMPLE_RATE, BITS_PER_SAMPLE, 1, true,
                                                 false);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format, SAMPLE_BUFFER_SIZE * BYTES_PER_SAMPLE);

            // the internal buffer is a fraction of the actual buffer size, this choice is arbitrary
            // it gets divided because we can't expect the buffered data to line up exactly with when
            // the sound card decides to push out its samples.
            buffer = new byte[SAMPLE_BUFFER_SIZE * BYTES_PER_SAMPLE / 3];
            bufferSize = 0;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // no sound gets made before this call
        line.start();
    }


    // plays a note in scientific pitch notation.
    public static void play(double duration, char pitch, int octave, int accidental) {
        // play no sound if the note is a rest
        if (pitch == 'R') {
            StdAudio2.play(note(0, duration, 0.5));
        }
        else {
            int steps = (pitch - 'A') * 2;

            // adjust for sharps/flats
            if (pitch == 'C' || pitch == 'D' || pitch == 'E') {
                steps -= 1;
            }
            else if (pitch == 'F' || pitch == 'G') {
                steps -= 2;
            }

            if (octave > 4 || (octave == 4 && pitch <= 'B')) {
                steps += (octave - 4) * 12;
            }
            else {
                steps -= (4 - octave) * 12;
            }

            // octave start at C so A and B are an octave lower
            if (pitch != 'A' && pitch != 'B') {
                steps -= 12;
            }

            // adjust for sharps and flats
            if (accidental > 0) {
                steps += 1;
            }
            else if (accidental < 0) {
                steps -= 1;
            }

            double hz = 440.0 * Math.pow(2, steps / 12.0);
            StdAudio2.play(note(hz, duration, 0.5));
        }
    }


    /**
     * Close standard audio.
     */
    public static void close() {
        line.drain();
        line.stop();
    }

    /**
     * Write one sample (between -1.0 and +1.0) to standard audio. If the sample
     * is outside the range, it will be clipped.
     */
    public static void play(double in) {

        // clip if outside [-1, +1]
        if (in < -1.0) in = -1.0;
        if (in > +1.0) in = +1.0;

        // convert to bytes
        short s = (short) (MAX_16_BIT * in);
        buffer[bufferSize++] = (byte) s;
        buffer[bufferSize++] = (byte) (s >> 8);   // little Endian

        // send to sound card if buffer is full
        if (bufferSize >= buffer.length) {
            line.write(buffer, 0, buffer.length);
            bufferSize = 0;
        }
    }

    /**
     * Write an array of samples (between -1.0 and +1.0) to standard audio. If a sample
     * is outside the range, it will be clipped.
     */
    public static void play(double[] input) {
        for (int i = 0; i < input.length; i++) {
            play(input[i]);
        }
    }


    /**
     * Save the double array as a sound file (using .wav or .au format).
     */
    public static void save(String filename, double[] input) {

        // assumes 44,100 samples per second
        // use 16-bit audio, mono, signed PCM, little Endian
        AudioFormat format = new AudioFormat(SAMPLE_RATE, 16, 1, true, false);
        byte[] data = new byte[2 * input.length];
        for (int i = 0; i < input.length; i++) {
            int temp = (short) (input[i] * MAX_16_BIT);
            data[2 * i + 0] = (byte) temp;
            data[2 * i + 1] = (byte) (temp >> 8);
        }

        // now save the file
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            AudioInputStream ais = new AudioInputStream(bais, format, input.length);
            if (filename.endsWith(".wav") || filename.endsWith(".WAV")) {
                AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File(filename));
            }
            else if (filename.endsWith(".au") || filename.endsWith(".AU")) {
                AudioSystem.write(ais, AudioFileFormat.Type.AU, new File(filename));
            }
            else {
                throw new RuntimeException("File format not supported: " + filename);
            }
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }


    /***********************************************************************
     * sample test client
     ***********************************************************************/

    // create a note (sine wave) of the given frequency (Hz), for the given
    // duration (seconds) scaled to the given volume (amplitude)
    public static double[] note(double hz, double duration, double amplitude) {
        int N = (int) (StdAudio2.SAMPLE_RATE * duration);
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = amplitude * Math.sin(2 * Math.PI * i * hz / StdAudio2.SAMPLE_RATE);
        return a;
    }

    /**
     * Test client - play an A major scale to standard audio.
     */
    public static void main(String[] args) {

        // 440 Hz for 1 sec
        double freq = 440.0;
        for (int i = 0; i <= StdAudio2.SAMPLE_RATE; i++) {
            StdAudio2.play(0.5 * Math.sin(2 * Math.PI * freq * i / StdAudio2.SAMPLE_RATE));
        }

        // scale increments
        int[] steps = { 0, 2, 4, 5, 7, 9, 11, 12 };
        for (int i = 0; i < steps.length; i++) {
            double hz = 440.0 * Math.pow(2, steps[i] / 12.0);
            StdAudio2.play(note(hz, 1.0, 0.5));
        }


        // need to call this in non-interactive stuff so the program doesn't terminate
        // until all the sound leaves the speaker.
        StdAudio2.close();

        // need to terminate a Java program with sound
        System.exit(0);
    }
}
