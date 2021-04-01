package Lecture07.Project1B;
import org.junit.Test;
import static org.junit.Assert.*;
/** Project 1B code is below
 * @author xerfat (at 2021.04.01)
 */
public class TestOffByN {
    static CharacterComparator offByN = new OffByOne();
    @Test
    public void testIsPalindromeOffByN() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));  // true
        assertTrue(offBy5.equalChars('f', 'a'));  // true
        assertFalse(offBy5.equalChars('f', 'h'));  // false
    }
}
