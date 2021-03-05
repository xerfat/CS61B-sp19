/** Class that determines whether or not a year is a leap year.
 *  @author xerfat
 */
public class LeapYear {

    /** Calls isLeapYear to print correct statement.
     *  @param  year to be analyzed
     */
    /** 普通闰年：公历年份是4的倍数的，且不是100的倍数。
     *  世纪闰年：公历年份是整百数的，必须是400的倍数才是世纪闰年。
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
    /** 先介绍与运算符（&和&&）：
     *  共同点：它们都表示运算符的两边都是true时，结果为true；
     *  不同点: 
     *  & 表示在运算时两边都会计算，然后再判断；
     *  &&表示先运算符号左边的东西，然后判断是否为true，
     *  是true就继续运算右边的然后判断并输出，是false就停下来直接输出不会再运行后面的东西。
     *  | 与 || 的区别同理。
     */    
        } else {
            return false;
        }
    }

    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.\n", year);
        } else {
            System.out.printf("%d is not a leap year.\n", year);
        }
    }

    /** Must be provided an integer as a command line argument ARGS. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
        }
        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number.\n", args[i]);
            }
        }
    }
}

