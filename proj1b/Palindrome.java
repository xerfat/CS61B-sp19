package Lecture07.Project1B;
import Lecture040506.Project1A.LinkedListDeque;
import org.junit.Test;

/** Project 1B
 * @author xerfat (2021.03.31)
 * 用三种方法实现isPalindrome，且按照作业要求不调用get()
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordList = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            wordList.addLast(word.charAt(i)); //get the i-th character in a String.
        }
        return wordList;
    }

    /* A palindrome is defined as a word that is the
       same whether it is read forwards or backwards.
       即，“回文” */

    /* isPalindrome solution 0: use recursion and private helper method
     *  josh hug建议用recursion+helper method，这里把deque转化为string似乎没有可以调用的方法？
     **/

    /* 引申 String, StringBuilder, StringBuffer
    * String 的值是不可变的，这就导致每次对String的操作都会生成新的String对象，不仅效率低下，而且浪费大量优先的内存空间
    *
    * StringBuffer 是可变类，和线程安全的字符串操作类，任何对它指向的字符串的操作都不会产生新的对象。每个StringBuffer对
    * 象都有一定的缓冲区容量，当字符串大小没有超过容量时，不会分配新的容量，当字符串大小超过容量时，会自动增加容量
    *
    * StringBuilder 可变类，速度更快
    * 此外还涉及线程安全的区别，目前看不懂
    **/
    private String dequeToString(Deque d) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < d.size(); i += 1) {
            char temp = (char) d.removeFirst();
            s.append(temp);
            //append是在尾部添加，一开始不知道，以为在首部
            //所以之前跑通纯属是因为对称
            d.addLast(temp); //删除首元素后立刻在尾位补回
        }
        return s.toString();
    }
   /* Overloading allows different methods to have the same name,
    but different signatures where the signature can differ by the number of
    input parameters or type of input parameters or both. Overloading is related
    to compile-time (or static) polymorphism. */

    /** 对单输入为String的isPalindrome进行重载，变成offByOne的Palindrome，写在前面方便看 */

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> t = wordToDeque(word);
        if (!cc.equalChars(t.removeFirst(), t.removeLast())) {
            return false;
        } else {
            return isPalindrome(dequeToString(t), cc);
        }
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            // 此处必须加上等于1的条件，不然字符数为奇数时，
            // t.removeLast() != t.removeFirst()，会将最后一个字符和null比较
            return true;
        }
        Deque<Character> t = wordToDeque(word);
        if (t.removeLast() != t.removeFirst()) {
            return false;
        } else {
            return isPalindrome(dequeToString(t));
        }
    }

    /* isPalindrome solution1: use wordToDeque
     *  好处：可以直接将反过来的deque和正序deque比较，但是比较次数会加倍
     **/

//    public boolean isPalindrome(String word) {
//        if (word.length() == 0) {
//            return true;
//        }
//        Deque<Character> reverse = wordToDeque(word);
//        for (int i = 0; i < word.length(); i += 1) {
//            if (!reverse.removeLast().equals(word.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }


    /* isPalindrome solution2: not use wordToDeque */
//    public boolean isPalindrome(String word) {
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//        for (int i = 0; i < word.length() / 2; i += 1) {
//            if (word.charAt(i) == word.charAt(word.length() - i -1)) {
//                continue;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

}
