package Lecture07.Project1B;
import org.junit.Test;
import static org.junit.Assert.*;
/** Project 1B code is below
 * @author xerfat (at 2021.04.01)
 */
public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('1','2'));
        assertTrue(offByOne.equalChars('%','&'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('@','$'));
    }
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.