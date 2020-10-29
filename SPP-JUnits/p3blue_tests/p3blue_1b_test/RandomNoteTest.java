import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RandomNoteTest {
    @Test
	@DisplayName("RandomNote only ever outputs notes within the range [60, 72] (and no other number) for input note 60")
	void testRange60() {
        int TRIALS = 20;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RandomNote", "60"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				Scanner scan = new Scanner(result);
				int resAsInt = scan.nextInt();
				if (resAsInt > 72 || resAsInt < 60) { 
					fail("RandomNote outputs " + result + " which is not in range [60, 72]."); 
				}
				
			} catch(InputMismatchException e) {
				fail("InputMismatchException");
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
	@Test
	@DisplayName("RandomNote only ever outputs notes within the range [72, 84] (and no other number) for input note 72")
	void testRange72() {
        int TRIALS = 20;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RandomNote", "72"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				Scanner scan = new Scanner(result);
				int resAsInt = scan.nextInt();
				if (resAsInt > 84 || resAsInt < 72) { 
					fail("RandomNote outputs " + result + " which is not in range [72, 84]."); 
				}
				
			} catch(InputMismatchException e) {
				fail("InputMismatchException");
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
}
