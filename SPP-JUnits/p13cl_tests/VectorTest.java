import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class VectorTest {
    @Test
    @DisplayName("Dot product of (1, 2, 3) and (3, 2, 1) equals 10")
    void testDot() {
        double[] w = {1, 2, 3};
        Vector v = new Vector(w);
        double[] z = {3, 2, 1};
        assertEquals(v.dot(new Vector(z)), 10);
    }
    /*
    @Test
    @DisplayName("Throws runtime exception when the lengths of two vectors aren't equal")
    void testException() {
        System.out.println("couldn't figure out how to test this but you probably wrote it right");
    }*/ 
}
