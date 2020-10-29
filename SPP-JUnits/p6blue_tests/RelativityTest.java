import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RelativityTest {
    @Test
	@DisplayName("Relativity draws rectangles with correct values for x, y, halfWidth, and halfHeight for five rectangles on each half")
	void test() {
        String correct1 = "0.1 0.75 0.1 0.25\n" + "0.30000000000000004 0.75 0.1 0.25\n" + "0.5000000000000001 0.75 0.1 0.25\n" + "0.7000000000000001 0.75 0.1 0.25\n" + "0.9 0.75 0.1 0.25\n" + "0.1 0.25 0.1 0.25\n" + "0.30000000000000004 0.25 0.1 0.25\n" + "0.5000000000000001 0.25 0.1 0.25\n" + "0.7000000000000001 0.25 0.1 0.25\n" + "0.9 0.25 0.1 0.25\n";
		String correct2 = "0.1 0.75 0.1 0.25\n" + "0.3 0.75 0.1 0.25\n" + "0.5 0.75 0.1 0.25\n" + "0.7 0.75 0.1 0.25\n" + "0.9 0.75 0.1 0.25\n" + "0.1 0.25 0.1 0.25\n" + "0.3 0.25 0.1 0.25\n" + "0.5 0.25 0.1 0.25\n" + "0.7 0.25 0.1 0.25\n" + "0.9 0.25 0.1 0.25\n";
		String correct3 = "0.1 0.75 0.1 0.25\n" + "0.30000000000000004 0.75 0.1 0.25\n" + "0.5 0.75 0.1 0.25\n" + "0.7000000000000001 0.75 0.1 0.25\n" + "0.9 0.75 0.1 0.25\n" + "0.1 0.25 0.1 0.25\n" + "0.30000000000000004 0.25 0.1 0.25\n" + "0.5 0.25 0.1 0.25\n" + "0.7000000000000001 0.25 0.1 0.25\n" + "0.9 0.25 0.1 0.25\n";
        String failMessage = "Should draw rectangles at these points or something similar:\n" + correct2 + "\nIf your output is very similar but it's still failing, you're free to move on. This is happening because of slight discrepancies in floating-point representation.";
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "Relativity", "5"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            failMessage = "Printed:\n" + result + "\n...\n\n" + failMessage;

			if (!correct1.equals(result)) {
				if (!correct2.equals(result)) {
					if (!correct3.equals(result)) {
						Scanner scan = new Scanner(result);
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.75) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if ((int) (scan.nextDouble() * 10) != 3) fail(failMessage);
						if (scan.nextDouble() != 0.75) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if ((int) (scan.nextDouble() * 10) != 5) fail(failMessage);
						if (scan.nextDouble() != 0.75) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if ((int) (scan.nextDouble() * 10) != 7) fail(failMessage);
						if (scan.nextDouble() != 0.75) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if ((int) (scan.nextDouble() * 10) != 9) fail(failMessage);
						if (scan.nextDouble() != 0.75) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 

						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage);
						if ((int) (scan.nextDouble() * 10) != 3) fail(failMessage);
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage);
						if ((int) (scan.nextDouble() * 10) != 5) fail(failMessage);
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage);
						if ((int) (scan.nextDouble() * 10) != 7) fail(failMessage);
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage);
						if ((int) (scan.nextDouble() * 10) != 9) fail(failMessage);
						if (scan.nextDouble() != 0.25) fail(failMessage); 
						if (scan.nextDouble() != 0.1) fail(failMessage); 
						if (scan.nextDouble() != 0.25) fail(failMessage);
						scan.close();
					}
				} 
			}


			

        } catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
    }
}
