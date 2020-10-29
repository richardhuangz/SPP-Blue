import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ChromaticTest {
    @Test
	@DisplayName("Chromatic prints every note in [60, 72] for input 60")
	void test60() {
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "Chromatic", "60"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
			Scanner scan = new Scanner(result);
			for (int i = 60; i < 73; i++) {
				if (!scan.hasNextInt()) {
					fail("Printed less than 13 notes");
				}
				if (scan.nextInt() != i) {
					fail("Should only print within [60, 72]");
				}
			}
			if (scan.hasNextInt()) fail("Printed too many notes");
		} catch(InputMismatchException e) {
			fail("InputMismatchException");
		} catch (Exception e) {/* Hopefully this never happens */}
	}
	
}
