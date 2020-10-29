/* *****************************************************************************
 *  Description:  A Note object represents a musical note in scientific music 
 *                notation. For example, middle C is represented as C4. The 
 *                constructor takes in the duration of the note as a 
 *                double, the pitch of the note as a char (A through G, and
 *                R for a rest), the octave as an int, and the accidental as  
 *                an int (positive int for a sharp, 0 for a natural, negative 
 *                for a flat).     
 *
 * Example:
 * > java-introcs Note
 *  1.0 C 4 0
 *  1.0 C 4 0
 *  1.0 E 4 0
 *  1.0 G 4 0
 *  1.0 R
 *  1.0 B 4 -1
 *  1.0 A 4 0
 **************************************************************************** */




public class Note {
    ___________________________;        // duration of the note
    ___________________________;        // pitch or rest of the note
    ___________________________;        // octave of the note
    ___________________________;        // accidental of the note

    
    public Note(double dur, char pitch, int oct, int acc) {

        illegalNote(dur, oct);  // calls a private method that checks the legality of the note
        
        // assign values to the instance variables
        _________ = dur;
        _________ = pitch;
        _________ = oct;
        _________ = acc;
    }

    // throws exception if you try to construct an illegal note
    // we haven't learned about throwing exceptions yet by the way
    private void illegalNote(double duration, int octave) {
        if (duration <= 0 || octave < 0 || octave > 10) {
            throw new IllegalArgumentException();
        }
    }

    // print this note and plays the sound this note represents
    public void play() {
        System.out.println(toString());
        StdAudio2.play(duration, note, octave, accidental);
    }

    // returns a string in the format "<duration> <pitch>" if the note
    // is a rest, otherwise returns a string in the format: "<duration> <pitch>
    // <octave> <accidental>"
    // For example "2.3 A 4 SHARP" and "1.5 R".
    public String toString() {
        if (_________) {
            return _________ + " " + _________;
        }
        else {
            return _________ + " " + _________ + " " + _________ + " " + _________;
        }
    }

    public static void main(String[] args) {
        Note n1 = new Note(1.0, 'C', 4, 0);
        Note n2 = new Note(1.0, 'E', 4, 0);
        Note n3 = new Note(1.0, 'G', 4, 0);
        Note n4 = new Note(1.0, 'R', 0, 0);
        Note n5 = new Note(1.0, 'B', 4, -1);
        Note n6 = new Note(1.0, 'A', 4, 0);
        n1.toString();
        n1.play();
        n2.play();
        n3.play();
        n4.play();
        n5.play();
        n6.play();
    }
}
