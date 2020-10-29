import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class WeightedRandomGroupsTest {
	@Test
	@DisplayName("WeightedRandomGroups prints output in the correct format")
	void testFormat() {
		String failMessage = "The format of your output should be:\n" +
			     "Participant 0 to Group #\n" + 
				 "...";

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroups", "5"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
			Scanner scan = new Scanner(result);

			// grab their first line
			String theirFirstLine = scan.nextLine();
			failMessage = "The format of your output is: \n" + theirFirstLine + "\n...\n\n" + failMessage;

			// check that the first row matches the format
			scan = new Scanner(result);
			if (!scan.next().equals("Participant")) { fail(failMessage); }
			if (scan.nextInt() != 0) { fail(failMessage); }
			if (!scan.next().equals("to")) { fail(failMessage); }
			if (!scan.next().equals("Group")) { fail(failMessage); }
			scan.nextInt();

			scan.close();

		} catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
	}


    @Test
	@DisplayName("WeightedRandomGroups outputs participant numbers in consecutive, increasing order")
	void testNumbers() {
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroups", "5"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());

			// check that the participant numbers go up in increasing order
			Scanner scan = new Scanner(result);
			for (int i = 0; i < 5; i++) {
				scan.next();
				int participantNum = scan.nextInt();
				if (participantNum != i) { fail("Your WeightedRandomGroups outputs: \n" + result); }
				scan.nextLine();
			}

			scan.close();
		} catch (Exception e) {/* Hopefully this never happens */ }
	}
	/*
	@Test
	@DisplayName("WeightedRandomGroups assigns participants to Groups 1, 2 or 3 with the correct probabilities")
	void testFair() {
        int TRIALS = 30;       // number of participants in WeightedRandomGroups
        double EPSILON = 0.12; // margin of allowable error

		int count1 = 0;
		int count2 = 0;
        int count3 = 0;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroups", "" + TRIALS});
		
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
			Scanner scan = new Scanner(result);

			// Count up the number of assignments per group
			for (int i = 0; i < TRIALS; i++) {
				scan.next(); scan.next(); scan.next(); scan.next();

				int groupNum = scan.nextInt();
				if (groupNum == 1) {
					count1++;
				} else if (groupNum == 2) {
					count2++;
				} else if (groupNum == 3) {
					count3++;
				}
				scan.nextLine();
		    }
		} catch (Exception e) {/* Hopefully this never happens *//*}

        double percent1 = (double) count1 / TRIALS;
        double percent2 = (double) count2 / TRIALS;
        double percent3 = (double) count3 / TRIALS;

        double error1 = Math.abs(percent1 - 0.2);
        double error2 = Math.abs(percent2 - 0.2);
        double error3 = Math.abs(percent3 - 0.6);

        if (error1 > EPSILON || error2 > EPSILON || error3 > EPSILON) {
            fail("Your WeightedRandomGroups divides " + TRIALS + " participants into the following groups: \n" +
			"\t\tGroup 1:\t" + count1 + String.format(" participants (%.2f%%)\n", percent1*100) +
			"\t\tGroup 2:\t" + count2 + String.format(" participants (%.2f%%)\n", percent2*100) +
			"\t\tGroup 3:\t" + count3 + String.format(" participants (%.2f%%)\n", percent3*100) +
			"This test relies on randomness to check correctness, so your code may still be correct. " +
			"You can try marking this activity again to rerun this test.");
        }
	}*/
	@Test
	@DisplayName("WeightedRandomGroups only ever outputs 1, 2 or 3 (and no other number) for group numbers")
	void test123() {

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroups", "5"});
		
		
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				Scanner scan = new Scanner(result);
				for (int i = 0; i < 5; i++) {
					scan.next(); scan.next(); scan.next(); scan.next();
					int num = scan.nextInt();
					if (num != 1 && num != 2 && num != 3) {
						fail("WeightedRandomGroups outputs " + num 
							+ " for group number (which is not 1, 2, or 3)");
					}
				}
			} catch (Exception e) {/* Hopefully this never happens */}
		
	}
}
