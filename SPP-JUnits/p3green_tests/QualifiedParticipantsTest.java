import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class QualifiedParticipantsTest {
	@Test
	@DisplayName("QualifiedParticipants prints output in the correct format")
	void testFormat() {
		String failMessage = "The format of your output should be:\n" +
			     "Person # qualified to participate in the study.\n" + 
				 "...";

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "QualifiedParticipants", "5", "0.1"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
			Scanner scan = new Scanner(result);

			// grab their first line
			String theirFirstLine = scan.nextLine();
			failMessage = "The format of your output is: \n" + theirFirstLine + "\n...\n\n" + failMessage;

			// check that the first row matches the format
			scan = new Scanner(result);
			if (!scan.next().equals("Person")) { fail(failMessage); }
			scan.nextInt();
			if (!scan.next().equals("qualified")) { fail(failMessage); }
			if (!scan.next().equals("to")) { fail(failMessage); }
			if (!scan.next().equals("participate")) { fail(failMessage); }
			if (!scan.next().equals("in")) { fail(failMessage); }
			if (!scan.next().equals("the")) { fail(failMessage); }
			if (!scan.next().equals("study.")) { fail(failMessage); }
			scan.close();

		} catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
	}


    @Test
	@DisplayName("QualifiedParticipants outputs the specified number of qualified people")
	void testNumPeople() {
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "QualifiedParticipants", "10", "0.1"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());

			// count up the number of output lines
			Scanner scan = new Scanner(result);
            int numLines = 0;
            while (scan.hasNextLine()) {
                scan.nextLine();
                numLines++;
            }           
			scan.close();

            if (numLines != 10) {
                fail("We requested 10 participants (java-introcs QualifiedParticipants 10 0.1), " +
                " but your QualifiedParticipants gave us " + numLines + " people.");
            }
		} catch (Exception e) {/* Hopefully this never happens */ }
	}
}
