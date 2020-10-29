import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RandomCansTest {
    @Test
	@DisplayName("RandomCans doesn't print duplicates")
	void testDuplicates() {
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RandomCans"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            Scanner scan = new Scanner(result);
            boolean[] seenBefore = new boolean[8];
			// check for duplicates
            while (scan.hasNextInt()) {
                int current = scan.nextInt();
                if (seenBefore[current]) fail("Printed duplicates:\n" + result);
                seenBefore[current] = true;
            }           
		} catch (Exception e) {
            /* Hopefully this never happens */ 
            fail(e.toString());}
	}
}
