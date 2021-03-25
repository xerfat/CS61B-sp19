package Lecture0405.Project01;

import org.omg.CORBA.Object;

/** Array based list.
 * @author xerfat
 */


/* Invariants:
   addLast: The next item we want to add, will go into position size
   getLast: The item we want to return is in position size - 1
   size: The number of items in the list should be size
 */
public class AList<Item> {
    private Item[] items;
    private int size;
    /** create an empty list. */
    public AList() {
        // Java does not allow generic arrays
        items = (Item[]) new Object[100];
        // Causes a compiler warning, which you should ignore
        size = 0;
    }

    /** Resize the underlying array to the target capacity */
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[size + capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public Item removeLast() {
        Item x = getLast();
        //or
        //int x = items[size - 1];
        //items[size - 1] = 0;
        // notion: setting deleted item to 0
        // is unnecessary to preserve invariant,
        // and unnecessary to for correctness.
        items[size - 1] = null; // Nulling out deleted items
        size -= 1;
        return x;
    }
}
