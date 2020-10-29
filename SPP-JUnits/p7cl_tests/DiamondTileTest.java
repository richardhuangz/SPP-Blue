import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DiamondTileTest {
    @Test
	@DisplayName("DiamondTile draws correct polygons for n = 1")
	void test() {
		String output = "(1.0, 0.5)\n" + "(0.5, 1.0)\n" + "(0.0, 0.5)\n" + "(0.5, 0.0)\n" + "(1.0, 0.5)\n" + "(0.5, 1.0)\n" + "(0.0, 0.5)\n" + "(0.5, 0.0)\n";
        String failMessage = "Should draw polygons at these points or something similar:\n" + output;
		ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "DiamondTile", "1"});
		try {
			Process p = pb.start();
			String result = new String(p.getInputStream().readAllBytes());
            failMessage = "Printed:\n" + result + "\n...\n\n" + failMessage;

			if (!output.equals(result)) { fail(failMessage); }

        } catch(InputMismatchException e) {
			fail(failMessage);
		} catch (Exception e) {/* Hopefully this never happens */ } 
    }
}
