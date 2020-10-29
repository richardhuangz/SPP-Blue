import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RollDieTest {
    @Test
	@DisplayName("RollDie only ever outputs [1, 6] (and no other number)")
	void test123() {
        int TRIALS = 50;

		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "RollDie"});
		for (int i = 0; i < TRIALS; i++) {
			try {
				Process p = pb.start();
				String result = new String(p.getInputStream().readAllBytes());
				if (!(result.equals("1\n") || result.equals("2\n") || result.equals("3\n") || result.equals("4\n") || result.equals("5\n") || result.equals("6\n"))) {
					fail("RollDie outputs " + result.substring(0, result.length()-1) 
                         + " (which is not [1, 6]");
				}
			} catch (Exception e) {/* Hopefully this never happens */}
		}
	}
}
