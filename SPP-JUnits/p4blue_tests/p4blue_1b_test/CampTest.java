import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CampTest {
    @Test
	@DisplayName("CampbellCans prints array elements in order")
	void test69() {
        String failMessage = "Should print:\n" + "0 1 2 3 4 5 6 7";
        ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "CampbellCans", "0", "1", "2", "3", "4", "5", "6", "7"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            failMessage = "Printed:\n" + result + "\n...\n\n" + failMessage;

			Scanner scan = new Scanner(result);
			
			for (int i = 0; i < 8; i++) {
                if (!scan.hasNextInt() || scan.nextInt() != i) {
                    fail(failMessage);
                }
            }
                  
			scan.close();

        } catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ }
    }
}
