/* *****************************************************************************
 *  Description:  Plays a melody of notes using an array of Note objects.
 *
 * Example:
 * > java-introcs MelodyOOP < twinkle.txt
 * > java-introcs MelodyOOP < mary.txt
 **************************************************************************** */

public class MelodyOOP {

    public static void main(String args[]) {

        // read the number of notes in the melody
        int n = _____________;

        // initialize the array of notes
        Note[] notes = _____________;

        // read the text file
        for (int i = 0; i < n; i++) {

            // read the important information
            double duration = StdIn.readDouble();
            StdIn.readChar();               
            char pitch = StdIn.readChar();
            int octave = StdIn.readInt();
            int accidental = StdIn.readInt();

            // initialize a new note in the array at index i
            notes[i] = new Note(______, ______, ______, ______);
        }

        // play each note
        for (int i = 0; i < n; i++) {
            _____________;
        }
    }
}

