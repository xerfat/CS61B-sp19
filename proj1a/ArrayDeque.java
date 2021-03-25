package Lecture0405.Project01;
import java.lang.reflect.Array;
/** Implementation of ArrayDeque in Project 1A
 * @author xerfat (at 2021.03.25)
 */

public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] items;

    public ArrayDeque() {
        size = 0;
        /** "nextFirst = 0" means starting the array at the last, i.e. 7
         *  but the array can actually start anywhere
         */
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[8];
    }

    public void resize(int length) {
        T[] newitems = (T[]) new Object[length];
        for (int i = 0; i < size; i += 1) {
            newitems[i] = get(i);
        }
        this.items = newitems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** logicAdd()、logicReduce()
     * 将双端队列中数的下一个数的位置映射到实际的数组中。
     * 例如，这一个数索引为items.length-1（即数组最后），则下一个数
     * 应该位于0位置.若索引还不到最后一位，则下一个数的位置
     * 就是下一个数的索引，正常+1即可。
     * <p>
     * 这个trick应该很常用于循环。每次将索引+1，一到某个阈值
     * 就从头开始。
     *
     * @param a
     * @return
     */
    public int logicAdd(int a) {
        return (a + 1) % items.length;
    }

    public int logicReduce(int a) {
        return (a - 1 + items.length) % items.length;
    }


    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = logicReduce(nextFirst);
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = logicAdd(nextLast);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = logicAdd(nextFirst);
        for (int j = 0; j < items.length; j += 1) {
            System.out.print(items[i] + " ");
            i = logicAdd(i);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T f = items[logicAdd(nextFirst)];
        nextFirst = logicAdd(nextFirst);
        items[nextFirst] = null;
        size -= 1;
        /** 这里之前出错了，典型新手犯蠢
         *  写成if (items.length >= 16 && (size / items.length < 0.25))
         *  把size / items.length当成除法，实际上是取整，恒为0
         */
        if (items.length >= 16 && (size < items.length * 0.25)) {
            resize(items.length / 2);
        }
        return f;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T l = items[logicReduce(nextLast)];
        nextLast = logicReduce(nextLast);
        items[nextLast] = null;
        size -= 1;
        if (items.length >= 16 && size < items.length * 0.25) {
            resize(items.length / 2);
        }
        return l;
    }

    public T get(int index) {
        return items[(logicAdd(nextFirst) + index) % items.length];
    }

    public ArrayDeque(ArrayDeque other) {
        size = 0;
        items = (T[]) new Object[other.items.length];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        for (int i = 0; i < items.length; i += 1) {
            items[i] = (T)other.items[i];
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(6);
        a.addFirst(5);

        a.addLast(7);
        a.addLast(8);

        a.addFirst(4);
        a.addFirst(3);
        a.addFirst(2);
        a.addFirst(1);

        a.addLast(9);
        a.addLast(10);
        a.printDeque();
        System.out.println(a.get(5));
        a.removeFirst();
        a.removeLast();
        a.removeFirst();
        a.removeLast();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();

        a.printDeque();
        ArrayDeque<Integer> b = new ArrayDeque<>(a);
        a.removeFirst();
        a.printDeque();
        b.printDeque();
    }
}