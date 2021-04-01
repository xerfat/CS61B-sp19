package Lecture07.Project1B;


public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char a, char b) {
        return a - b == 1 || b - a == 1;
    }
}
