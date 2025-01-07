import org.example.util.AnagramGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AnagramGeneratorTest {
    @Test
    void testValidInput() {
        List<String> result = AnagramGenerator.generateAnagrams("abc");
        assertEquals(6, result.size());
    }

    @Test
    void testSingleLetter() {
        List<String> result = AnagramGenerator.generateAnagrams("a");
        assertEquals(1, result.size());
    }

    @Test
    void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AnagramGenerator.generateAnagrams(""));
        assertEquals("Input must be non-empty and contain only letters.", exception.getMessage());
    }
}
