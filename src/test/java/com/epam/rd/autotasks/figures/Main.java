package com.epam.rd.autotasks.figures;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(10, 0);
        Point c = new Point(5, 5);
        Point d = new Point(0, 10);
        Quadrilateral abcd = new Quadrilateral(a, b, c, d);
        Point buf = abcd.centroid();
        //buf.toString();


    }
}
