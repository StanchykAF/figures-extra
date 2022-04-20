package com.epam.rd.autotasks.figures;

import java.util.ArrayList;

class Quadrilateral extends Figure {
    private final Point A, B, C, D;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        A = a;
        B = b;
        C = c;
        D = d;
        if (A == null || B == null || C == null || D == null) {             //not exist
            throw new IllegalArgumentException();
        }
        if (area() <= 0 ) {                                                 //not exist
            throw new IllegalArgumentException();
        }
        if (new Triangle(A, B, C).area() <= 0 ||                            //not exist because one point is between another two
                new Triangle(B, C, D).area() <= 0 ||
                new Triangle(C, D, A).area() <= 0 ||
                new Triangle(D, A, B).area() <= 0) {
            throw new IllegalArgumentException();
        }
        if (new Segment(A, C).intersection(new Segment(B, D)) == null) {    //not convex
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        Point centrA, centrB, centrC, centrD;
        centrA = new Triangle(B, C, D).centroid();
        centrB = new Triangle(A, C, D).centroid();
        centrC = new Triangle(A, B, D).centroid();
        centrD = new Triangle(A, B, C).centroid();
        return new Segment(centrA, centrC).intersection(new Segment(centrB, centrD));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;                                //Same object -> is the same
        if (getClass() != figure.getClass()) return false;              //not the same types -> not the same
        if (!A.isTheSame(((Quadrilateral) figure).A) &&
                !A.isTheSame(((Quadrilateral) figure).B) &&
                !A.isTheSame(((Quadrilateral) figure).C) &&
                !A.isTheSame(((Quadrilateral) figure).D)) return false;
        if (!B.isTheSame(((Quadrilateral) figure).A) &&
                !B.isTheSame(((Quadrilateral) figure).B) &&
                !B.isTheSame(((Quadrilateral) figure).C) &&
                !B.isTheSame(((Quadrilateral) figure).D)) return false;
        if (!C.isTheSame(((Quadrilateral) figure).A) &&
                !C.isTheSame(((Quadrilateral) figure).B) &&
                !C.isTheSame(((Quadrilateral) figure).C) &&
                !C.isTheSame(((Quadrilateral) figure).D)) return false;
        return D.isTheSame(((Quadrilateral) figure).A) ||
                D.isTheSame(((Quadrilateral) figure).B) ||
                D.isTheSame(((Quadrilateral) figure).C) ||
                D.isTheSame(((Quadrilateral) figure).D);

    }

    public double area() {
        return new Triangle(A, B, C).area() + new Triangle(A, C, D).area();
    }
}
