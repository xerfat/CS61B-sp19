package Lecture0405.Project01;

/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */

public class SLList {

    /**
     * Nested class definition
     * could have made IntNode a private nested class
     * if we wanted.
     * Also, we can declare IntNode static, since it never uses any of SLList's
     * instance variables or methods
     */

    private static class IntNode {
        /** 当嵌套类被定义为public时，类内部的public之类的
         * access modifier就不再重要了
         */
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** Instance variables, constructors, and methods of SLList
     * typically go below nested class definition.
     */

    /**
       * Do not mess with first.
       * Use the 'private keyword to prevent code in other class'
       * from using members (or constructors) of a class
       */

    /** The first item (if it exists) is at sentinel.next.  */
        private IntNode sentinel;
        private int size;

        public SLList() {
            sentinel = new IntNode(66, null);
            size = 0;
        }

        public SLList(int x) {
            sentinel = new IntNode(66, null);
            sentinel.next = new IntNode(x, null);
            size = 1;
        }

        public void addFirst(int x) {
            sentinel.next = new IntNode(x, sentinel.next);
            size += 1;
        }

        public int getFirst() {
            return sentinel.next.item;
        }

        /** add an item to the end of the list */

        public void addLast(int x) {
//            if (first == null) {
//                first = new IntNode(x, null);
//                return;
//            }
            IntNode ptr = sentinel;
            /* move ptr until it reaches the end of the list.*/
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = new IntNode(x, null);
            size += 1;
        }

        /** Returns the size of the list starting at IntNode p.
          * @author Josh Hug
          * 以下是lecture里面的方法，recursive
          */
//        private static int size(IntNode p) {
//            if (p.next == null) {
//                return 1;
//            }
//            return 1 + size(p.next);
//        }
//
//        public int size() {
//            return size(first);
//        }
            /** Returns the size of the list starting at IntNode p.
              * @author Josh Hug
              * 以下是lecture里面提升计算size效率的方法，添加size变量
              */
            public int size() {
                return size;
            }
        /** @author xerfat
         * 以下是我的方法，iterative
         */
//        public int size() {
//            IntNode ptr = first;
//            if (ptr == null) {
//                return 0;
//            }
//            int count = 1;
//            while (ptr.next != null) {
//                ptr = ptr.next;
//                count += 1;
//            }
//            return count;
//        }

        public static void main(String[] args) {
            /** create a list of one integer, namely 10 */
            //SLList s = new SLList();
            SLList L = new SLList(15);
            L.addFirst(10);
            L.addFirst(5);
            int x = L.getFirst();
            System.out.println("The first item of this list is: " + x);

            L.addLast(1);
            int y = L.size();

            System.out.println("The size of this list is: " + y);
        }
}
