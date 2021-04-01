package Lecture07.Project1B;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
        // Deque class does not provide an equals method
        // and thus it won’t work the way you expect.
    }

    @Test
    public void testIsPalindrome() {
        assertFalse(palindrome.isPalindrome("panama"));
        assertFalse(palindrome.isPalindrome("panamal"));
        assertTrue(palindrome.isPalindrome("abcba"));
        assertTrue(palindrome.isPalindrome("abccba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("q"));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("q", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("aqq", cc));
        assertFalse(palindrome.isPalindrome("ekalf", cc));
        assertTrue(palindrome.isPalindrome("bdfeca", cc));
        assertTrue(palindrome.isPalindrome("bdeca", cc));
    }
}