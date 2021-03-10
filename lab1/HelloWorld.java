// package Lecture01;
/** @author xerfat */
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args){
    // public 这是一个公有的方法
    // static 这是一个静态的方法
    // void 没有返回值
    // main 方法名
    // String[] args，这是参数，程序运行的时候可以加上参数的，参数的类型是字符串数组，放在args这个参数中
        System.out.println("Hello World!");
    }
}
    // Java considers classes very important !!!!
    // All code must be in classes, which forces you to be object-oriented


    // Java vs Python
    // In general, Java is much faster than Python, though the startup time for a new Java program is longer

    /*
    Teaching conclusion:
    1. In Java, all code must be part of a class.
    2. Classes are defined with "public class CLASSNAME"
    3. We use '{ }'(curly braces) to delineate the beginning and ending of things.
    4. We must end lines with a ';'(semicolon)
    5. The code we want to run must be inside 'public static void main(String[] args)'
     */