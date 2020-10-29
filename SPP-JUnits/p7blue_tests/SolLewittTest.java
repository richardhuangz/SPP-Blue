import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SolLewittTest {
	@Test
	@DisplayName("reverseColors({'R', 'G', 'B', 'Y'}) should output {'Y', 'B', 'G', 'R'}")
	void reverse1() {
        char[] original = {'R', 'G', 'B', 'Y'};
        char[] reversed = {'Y', 'B', 'G', 'R'};
        assertArrayEquals(reversed, SolLewitt.reverseColors(original));
    }

	@Test
	@DisplayName("original[] should remain unchanged after calling reverseColors(original[])")
	void reverse1DoesNotChangeOriginal() {
        char[] original = {'R', 'G', 'B', 'Y'};
        char[] input = {'R', 'G', 'B', 'Y'};
        SolLewitt.reverseColors(input);
        assertArrayEquals(original, input);
    }

    @Test
	@DisplayName("After reverseColors2(original[]), original[] should be reversed")
	void reverse2() {
        char[] original = {'R', 'G', 'B', 'Y'};
        char[] reversed = {'Y', 'B', 'G', 'R'};
        SolLewitt.reverseColors2(original);
        assertArrayEquals(reversed, original);
    }
}

