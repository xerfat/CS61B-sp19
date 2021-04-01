package Lecture07.Project1B;
/** Project 1B code is below
 * @author xerfat (at 2021.04.01)
 */
public class OffByN implements CharacterComparator {

    public int n;

    public OffByN(int N) {
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
        // return x - y == n || y - x == n;
    }
}
