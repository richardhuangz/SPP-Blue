import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MidiToFreqTest {
    @Test
	@DisplayName("MidiToFrequency prints correct MIDI note and frequency in hz for MIDI note 69")
	void test69() {
        String failMessage = "Should print:\n" + "MIDI:        69\n" + "Frequency:   440.0";
        ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "MidiToFrequency", "69"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            failMessage = "Printed:\n" + result + "\n...\n\n" + failMessage;

			Scanner scan = new Scanner(result);
			
			if (!scan.next().equals("MIDI:")) { fail(failMessage); }
			if (scan.nextInt() != 69) { fail(failMessage); }
			if (!scan.next().equals("Frequency:")) { fail(failMessage); }
			if (scan.nextDouble() != 440.0) { fail(failMessage); }
                  
			scan.close();

        } catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
    }
	@Test	
	@DisplayName("MidiToFrequency prints correct MIDI note and frequency in hz for MIDI note 60")
	void test60() {
        String failMessage = "Should print:\n" + "MIDI:        60\n" + "Frequency:   261.6255653005986";
        ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "MidiToFrequency", "60"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            failMessage = "Printed:\n" + result + "\n...\n\n" + failMessage;

			Scanner scan = new Scanner(result);
 			if (!scan.next().equals("MIDI:")) { fail(failMessage); }
			if (scan.nextInt() != 60) { fail(failMessage); }
			if (!scan.next().equals("Frequency:")) { fail(failMessage); }
			if (scan.nextDouble() != 261.6255653005986) { fail(failMessage); }
                  
			scan.close();

        } catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
    }
}
