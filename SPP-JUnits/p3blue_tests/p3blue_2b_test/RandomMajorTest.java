import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RandomMajorTest {
    @Test
	@DisplayName("RandomNoteMajor only ever outputs notes within the range [60, 72] (and no other number) for input note 60")
	void testRange60() {
        int TRIALS = 20;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RandomNoteMajor", "60"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				Scanner scan = new Scanner(result);
				int resAsInt = scan.nextInt();
				if (resAsInt > 72 || resAsInt < 60) { 
					fail("RandomNoteMajor outputs " + result + " which is not in range [60, 72]."); 
				}
				
			} catch(InputMismatchException e) {
				fail("InputMismatchException");
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
	@Test
	@DisplayName("RandomNoteMajor correctly identifies notes in the major key for input note 60")
	void testMajor() {
        int TRIALS = 20;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RandomNoteMajor", "60"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				Scanner scan = new Scanner(result);
				int resAsInt = scan.nextInt();
				if (resAsInt == 61 || resAsInt == 63 || resAsInt == 66 || resAsInt == 68 || resAsInt == 70) { 
					if (result.length() != 25) {
						fail("Printed:\n" + result + "\neven though the note isn't in the major key.");
					}
				}
				else {
					if (result.length() != 22) {
						fail("Printed:\n" + result + "\neven though the note is in the major key.");
					}
				}
				
			} catch(InputMismatchException e) {
				fail("InputMismatchException");
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
}
