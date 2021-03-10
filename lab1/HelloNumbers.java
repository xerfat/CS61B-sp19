// package Lecture01;
/** @authored xerfat */
public class HelloNumbers {
    public static void main(String[] args){
        int x;
        x = 0;
        // or int x = 0;
        int sum = 0;
        while (x < 10){
            // System.out.println(x + " ");
            // System.out.print(x + " ");
            // Our print statement is just System.out.print instead of System.out.println.
            // This means we should not include a newline (a return).
            sum = sum + x;
            System.out.print(sum + " ");
            x = x + 1;
        }
        // x = "horse";  //java: 不兼容的类型: java.lang.String无法转换为int
    }
}
    // In Java, variables have specific type, which can never change. This is called static typing
    /*
    1. Before Java variables can be used, they must be declared.
    2. Java variables must have a specific type.
    3. Java variables can never change.
    4. Types are verified before the code even runs !!! (different from Python)
     */