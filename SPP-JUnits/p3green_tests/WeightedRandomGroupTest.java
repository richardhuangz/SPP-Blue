import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WeightedRandomGroupTest {
    @Test
	@DisplayName("WeightedRandomGroup only ever outputs 1, 2 or 3 (and no other number)")
	void test123() {
        int TRIALS = 20;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroup"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				if (!(result.equals("1\n") || result.equals("2\n") || result.equals("3\n"))) {
					fail("WeightedRandomGroup outputs " + result.substring(0, result.length()-1) 
                         + " (which is not 1, 2, or 3");
				}
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
	/*
	@Test
	@DisplayName("WeightedRandomGroup outputs 1, 2 or 3 with the correct probabilities")
	void testFair() {
        int TRIALS = 30;       // number of times to run WeightedRandomGroup
        double EPSILON = 0.12; // margin of allowable error

		int count1 = 0;
		int count2 = 0;
        int count3 = 0;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "WeightedRandomGroup"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				if (result.equals("1\n")) {
					count1++;
				} else if (result.equals("2\n")) {
					count2++;
				} else if (result.equals("3\n")) {
					count3++;
				}
			} catch (Exception e) {/* Hopefully this never happens *//*}
		}

        double percent1 = (double) count1 / TRIALS;
        double percent2 = (double) count2 / TRIALS;
        double percent3 = (double) count3 / TRIALS;

        double error1 = Math.abs(percent1 - 0.2);
        double error2 = Math.abs(percent2 - 0.2);
        double error3 = Math.abs(percent3 - 0.6);

        if (error1 > EPSILON || error2 > EPSILON || error3 > EPSILON) {
            fail("Out of " + TRIALS + " trials, your WeightedRandomGroup output: \n" +
			"\t\t'1':\t" + count1 + String.format(" times (%.2f%%)\n", percent1*100) +
			"\t\t'2':\t" + count2 + String.format(" times (%.2f%%)\n", percent2*100) +
			"\t\t'3':\t" + count3 + String.format(" times (%.2f%%)\n", percent3*100) +
			"This test relies on randomness to check correctness, so your code may still be correct. " +
			"You can try marking this activity again to rerun this test.");
        }
	}*/
}
