package Lecture07.Project1B;

/** Project 1B code is below
 * @author xerfat (at 2021.04.01)
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char a, char b) {
        return a - b == 1 || b - a == 1;
    }
}
