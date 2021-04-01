package Lecture07.Project1B;

import Lecture040506.Project1A.LinkedListDeque;

/** Implementation of Project 1B
 *  @author xerfat (2021.03.30)
 */

public interface Deque<T> {
    /* For methods in both LinkedListDeque and ArrayDeque */
    void addFirst(T item);
    // Modifier 'public' is redundant for interface methods
    void addLast(T item);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    /* For both */
    default boolean isEmpty() {
        return size() == 0;
    }
}
