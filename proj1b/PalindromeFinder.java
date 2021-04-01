package Lecture07.Project1B;
import Lecture03.Lab02.DebugPractice.In;
import Lecture040506.Project1A.AList;
import Lecture040506.Project1A.ArrayDeque;

import java.util.Arrays;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        int N;
        In in = new In("/Lecture07/Project1B/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator cc = new OffByOne();

        int[] countN = new int[26];
        Deque<String> longest = new ArrayDeque<>();
        longest.addFirst("");

        
        while (!in.isEmpty()) {
            String word = in.readString();
            for (int i = 0; i < 26; i += 1) {
                if (word.length() >= minLength && palindrome.isPalindrome(word, new OffByN(i))) {
                    if (word.length() > longest.get(0).length()) {
                        longest = new ArrayDeque<>();
                        longest.addFirst(word);
                    } else if (word.length() == longest.get(0).length()) {
                        //获得字符串的长度是s.length()  是方法
                        //获得数组长度是s.length  是属性
                       longest.addLast(word);
                    }
                    System.out.println(word);
                    countN[i] += 1;
                    break;
                }
            }
        }
        System.out.println("The longest palindrome(s) is(are):");
        for (int i = 0; i < longest.size(); i += 1) {
            System.out.print(longest.get(i) + " ");
            //用printDeque会打印出null
        }
        System.out.println();


        int max = countN[0];
        int mIndex = 0;
        for (int i = 0; i < countN.length; i++) {
            if (max < countN[i]){
                max = countN[i];
                mIndex = i;
            }
        }
        System.out.println("There are the most palindromes when N = "+ mIndex +
               ", and the number is " + max);
    }
}
//Uncomment this class once you've written isPalindrome.
