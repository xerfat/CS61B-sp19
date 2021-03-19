package Lecture0405.Project01;
public class LinkedListDeque<LocheNess> {
    /** Project 1A code is below
     * @author xerfat (at 2021.03.18)
     */

    private class StuffNode {
        public LocheNess item;
        public StuffNode prev;
        public StuffNode next;

        public StuffNode(StuffNode p, LocheNess i, StuffNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;


//    if (t instanceof String) {
//        t = "a";
//    } else if (t instanceof Integer) {
//        t = 66;
//    }

    public LinkedListDeque() {
        //错误写法
        //sentinel = new StuffNode(sentinel,66,sentinel);、、在实例化sentinel时，
        //sentinel本身还只是null，用sentinel和sent.next去实例化sentinel当然是行不通的。
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    public LinkedListDeque(LocheNess x) {
//        sentinel = new StuffNode(null,66,null);
//        sentinel.next = new StuffNode(sentinel, x, null);
//        sentinel.prev = sentinel.next;
//        size = 1;
//    }

    public void addFirst(LocheNess x) {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }


    public void addLast(LocheNess x) {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        } else {
//            return false;
//        }
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode ptr = sentinel.next;
        for (int i = 0; i < size; i += 1) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public LocheNess removeFirst() {
        if (size == 0) {
            return null;
        } else {
            LocheNess r = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return r;
            /** 另一种写法 */
//            LochNess r = sentinel.next.item;
//            sentinel.next.next.prev = sentinel;
//            sentinel.next = sentinel.next.next;
//            size -= 1;
//            return r;
        }
    }

    public LocheNess removeLast() {
        if (size == 0) {
            return null;
        } else {
            LocheNess r = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return r;
            /** 另一种写法 */
//            LochNess r = sentinel.next.item;
//            sentinel.prev.prev.next = sentinel;
//            sentinel.prev = sentinel.prev.prev;
//            size -= 1;
//            return r;
        }
    }

    /** get must use iteration, not recursion. */
    public LocheNess get(int index) {
        int i = 0;
        StuffNode ptr = sentinel;
        if (index > size) {
            return null;
        }
        while (i != index) {
            ptr = ptr.next;
            i += 1;
//            if (ptr == null) {
//                return null;
//            }
        }
        return ptr.item;
    }

    public LocheNess getRecursiveHelp(StuffNode p, int i) {
        if (i == 0) {
            return p.item;
        }
        return getRecursiveHelp(p.next, i - 1);
    }

    public LocheNess getRecursive(int index) {
        if (index > size) {
            return null;
        }
        StuffNode ptr = sentinel;
        return getRecursiveHelp(ptr, index);
    }

    /** Creating a deep copy means that you create an entirely new LinkedListDeque,
     * with the exact same items as other.
     * However, they should be different objects. */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;

        for (int i = 1; i <= other.size(); i += 1) {
            addLast((LocheNess)other.get(i));
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();

        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.addLast(4);
        L.addLast(5);
        System.out.println(L.size());
        System.out.println(L.get(1));
        L.printDeque();
        L.removeFirst();
        L.removeLast();
        L.printDeque();
        System.out.println(L.getRecursive(3));
        System.out.println("L1");
        LinkedListDeque<Integer> L1 = new LinkedListDeque(L);
        System.out.println(L1.getRecursive(3));
        System.out.println(L1.size());
        System.out.println(L1.get(1));
        L1.printDeque();
        L1.removeFirst();
        L1.removeLast();
        L1.printDeque();


    }
}
