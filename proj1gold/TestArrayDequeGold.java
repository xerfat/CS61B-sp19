package Lecture07.Project1Gold;
/** Project 1 Gold code is below
 * @author xerfat (at 2021.04.03)
 * @source https://github.com/akinguyen/Data_structure/blob/master/proj1gold/TestArrayDequeGold.java
 */
import static org.junit.Assert.*;
import Lecture02.Project0.examples.StdRandom;
import Lecture07.Project1B.Deque;
import org.junit.Test;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
    // 先addLast，再addFirst，test方便写
    // addLast for 10 times
    Boolean testResult = true;
    String operation = "";
    @Test
    public void testArrayDeque() {

        while (testResult) {
            int randomP = StdRandom.uniform(6);
            int randomA = StdRandom.uniform(50);

            if (randomP == 0) {
                sad.addFirst(randomA);
                ads.addFirst(randomA);
                testResult =(ads.get(0).equals(sad.get(0)));
                operation += "addFirst("+randomA+")"+'\n';
            }

            if (randomP == 1) {
                sad.addLast(randomA);
                ads.addLast(randomA);
                testResult =(ads.get(ads.size() - 1).equals(sad.get(sad.size() - 1)));
                operation += "addLast("+randomA+")"+'\n';
            }

            if (randomP == 2) {
                if (sad.size() > 0 && ads.size() > 0) {
                    /* Java will freely convert from Integer (boxed type) to int
                    (primitive type). This is called unboxing. However, only
                    reference types can be null, so if you try to automatically
                    convert a null Integer to an int, you’ll get a NullPointerException
                    in your own code. The StudentArrayDeque is buggy and may return a null
                     (incorrectly), which can trigger this problem in your code.*/
                    Integer actual = sad.removeFirst();
                    Integer expected = ads.removeFirst();
                    testResult = actual.equals(expected);
                    operation += "removeFirst()"+'\n';
                }
            }

            if (randomP == 3) {
                if (sad.size() > 0 && ads.size() > 0) {
                    Integer actual = sad.removeLast();
                    Integer expected = ads.removeLast();
                    testResult = actual.equals(expected);
                    operation += "removeLast()" + '\n';
                }
            }

            if (randomP == 4) {
                Boolean actual = sad.isEmpty();
                Boolean expected =ads.isEmpty();
                testResult = actual.equals(expected);
                operation += "isEmpty()"+'\n';
            }

            if (randomP == 5) {
                Integer actual = sad.size();
                Integer expected =ads.size();
                testResult = actual.equals(expected);
                operation += "size()"+'\n';
            }

            if (randomP == 6) {
                int randomI = StdRandom.uniform(ads.size() - 1);
                Integer actual = sad.get(randomI);
                Integer expected =ads.get(randomI);
                testResult = actual.equals(expected);
                operation += "get("+randomI+")"+'\n';
            }
        }
        assertEquals(operation, testResult, true);
//        for (int i =  1; i < 10; i += 1) {
//            int randomL = StdRandom.uniform(50);
//            sad.addLast(randomL);
//            ads.addLast(randomL);
//        }
//
//        // Test all 10 added numbers
//        for (int i = 0; i < sad.size(); i += 1) {
//            assertEquals("Oops! The 'get()' method should get "+ads.get(i)+", however, it got "
//                    + sad.get(i), ads.get(i), sad.get(i));
//        }
//
//        // addFirst for 10 times
//        for (int i = 0; i < 10; i += 1) {
//            int randomF = StdRandom.uniform(50);
//            sad.addFirst(randomF);
//            ads.addFirst(randomF);
//        }
//
//
//        // Test all 10 added numbers
//        for (int i = 0; i < sad.size(); i += 1) {
//            assertEquals(sad.get(i), ads.get(i));
//        }
//
//        // remove First for 10 times
//        for (int i = 0; i < 10; i += 1) {
//            int actual = sad.removeFirst();
//            int expected = ads.removeFirst();
//            assertEquals("Oops! The 'removeFirst()' method should remove "+expected+", however, it removed "
//                    + actual, expected, actual);
//        }
//        sad.printDeque();
//
//        // remove Last for 10 times
//        for (int i = 0; i < 10; i += 1) {
//            int actual = sad.removeLast();
//            int expected = ads.removeLast();
//            assertEquals("Oops! The 'removeFirst()' method should remove "+expected+", however, it removed "
//                    + actual, expected, actual);
//        }
    }
}
