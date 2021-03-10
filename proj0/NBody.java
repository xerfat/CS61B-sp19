//package Lecture02.Project0;
/** 
  * @author xerfat (at 2021.03.09) 
  */
import java.lang.Math;

public class NBody {

    public static String backgroundToDraw = "images/starfield.jpg";

    public static double readRadius(String fileName) {
        double r;
        In in = new In(fileName);
        int firstItemInFile = in.readInt();
        r = in.readDouble();
        return r;
    }

    public static Body[] readBodies(String fileName) {
        
        In in = new In(fileName);
        int n = in.readInt();         // Number of planets
        double r = in.readDouble();
        Body[] b = new Body[n];
        double xxPos,yyPos,xxVel,yyVel,mass;
        String imgFileName;

        for (int i = 0; i < n; i = i + 1) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            imgFileName = in.readString();
            b[i] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return b;
    }

    public static int readNum(String fileName) {
        In in = new In(fileName);
        int n = in.readInt();
        return n;
    }

    public static void drawBackground(double r) {
        //StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-r, r);
        StdDraw.clear();
        StdDraw.picture(0, 0, backgroundToDraw, 2*r, 2*r);
        //StdDraw.show();
        //StdDraw.pause(1000);
    }

    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String fileName = args[2];

        int n;                    // Num of Bodies
        n = readNum(fileName);

        double r;                 // Radius
        r = readRadius(fileName);

        Body[] b = new Body[n];   // Bodies
        b = readBodies(fileName);

        
        double[] xForces = new  double[n];
        double[] yForces = new  double[n];


        /** a graphics technique to prevent flickering in the animation. */
        StdDraw.enableDoubleBuffering();
        StdAudio.play("./audio/2001.mid");
        for (double s = 0; s < T; s = s + dt) {

            for (int i = 0; i < b.length; i += 1) {
                xForces[i] = b[i].calcNetForceExertedByX(b);
                yForces[i] = b[i].calcNetForceExertedByY(b);
                
            }

            for (int i = 0; i < b.length; i += 1) {
                b[i].update(dt, xForces[i], yForces[i]);
            }
            /** Draw the background */
            drawBackground(r);

            /** Use loop to draw all the planets and sun */
            for (int i = 0; i < b.length; i += 1) {
                Body.draw(b[i]);
            }

            StdDraw.show();
            StdDraw.pause(1);

       }

       StdOut.printf("%d\n", b.length);
       StdOut.printf("%.2e\n", r);

       for (int i = 0; i < b.length; i++) {
           StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
           b[i].xxPos, b[i].yyPos, b[i].xxVel,
           b[i].yyVel, b[i].mass, b[i].imgFileName);   
        }
    }
}
