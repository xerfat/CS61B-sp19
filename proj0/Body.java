//package Lecture02.Project0;
/** 
  * @author xerfat (at 2021.03.09) 
  */
import java.lang.Math;

public class Body {

    public double xxPos; // Its current x position
    public double yyPos; // Its current y position
    public double xxVel; // Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass;  //Its mass
    public String imgFileName;

    public static final double G = 6.67e-11;
    // The name of the file that corresponds to the image that depicts the body (for example, jupiter.gif)

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** 第二个构造函数：这也是对第一个构造函数的重载
     *  关于this的好文章，https://zhuanlan.zhihu.com/p/120934262
     */
    public Body(Body b) {
       this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    
    public double calcDistance(Body b) {
        double r; // diatance between 2 particles
        r = Math.sqrt ( Math.pow ( (this.xxPos - b.xxPos), 2 ) 
                      + Math.pow ( (this.yyPos - b.yyPos), 2 ) );
        // r = Math.sqrt ( (this.xxPos - e.xxPos) * (this.xxPos - e.xxPos)
        //               + (this.yyPos - e.yyPos) * (this.yyPos - e.yyPos) );
        return r;
    }


    public double calcForceExertedBy(Body b) {
        double f; // force exerted on this body by the given body 'd'
        double r = this.calcDistance(b);
        f = G * this.mass * b.mass / (r * r);
        return f;
    }


    public double calcForceExertedByX(Body b) {
        double fx;
        double f;
        double r;
        f = this.calcForceExertedBy(b);
        r = this.calcDistance(b);
        fx = f * (b.xxPos - this.xxPos) / r;
        return fx;
    }


    public double calcForceExertedByY(Body b) {
        double fy;
        double f;
        double r;
        f = this.calcForceExertedBy(b);
        r = this.calcDistance(b);
        fy = f * (b.yyPos - this.yyPos) / r;
        return fy;
    }


    public double calcNetForceExertedByX(Body[] l) {
        double fNetX = 0;
        for (int i = 0; i < l.length; i = i + 1) {
            if (this.equals(l[i])) {
                continue;
            }
            fNetX = fNetX + this.calcForceExertedByX(l[i]);
        }
        
        /** In this case, while loop looks more verbose */

        // while (i < l.length) {
        //     if (this.equals(l[i])) {
        //         continue;
        //     }
        //     fNetX = this.calcForceExertedByX(l[i]);
        //     i = i + 1;
        // }
        return fNetX;
    }


    public double calcNetForceExertedByY(Body[] l) {
        double fNetY = 0;
        for (int i = 0; i < l.length; i = i + 1) {
            if (this.equals(l[i])) {
                continue;
            }
            fNetY = fNetY + this.calcForceExertedByY(l[i]);
            i = i + 1;
        }

        // int i = 0;
        // while (i < l.length) {
        //     if (this.equals(l[i])) {
        //         continue;
        //     }
        //     fNetY = fNetY + this.calcForceExertedByY(l[i]);
        //     i = i + 1;
        // }
        return fNetY;
    }


    public void update(double dt, double fx, double fy) {
        double axNet, ayNet;         // accerleration
        double xxVelNew, yyVelNew;   // new velocity
        double xxPosNew, yyPosNew;   // new position

        axNet = fx / this.mass;
        ayNet = fy / this.mass;
        xxVelNew = this.xxVel + axNet * dt;
        yyVelNew = this.yyVel + ayNet * dt;
        xxPosNew = this.xxPos + xxVelNew * dt;
        yyPosNew = this.yyPos + yyVelNew * dt;

        this.xxVel = xxVelNew;
        this.yyVel = yyVelNew;
        this.xxPos = xxPosNew;
        this.yyPos = yyPosNew;
    }


    public static void draw(Body b) {
        StdDraw.picture(b.xxPos, b.yyPos, "images/" + b.imgFileName);
        
        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        // StdDraw.show();
        // StdDraw.pause(10);
    }
}


