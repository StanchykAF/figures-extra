package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point A, B, C;

    public Triangle(Point a, Point b, Point c) {
        A = a;
        B = b;
        C = c;
        if (A == null || B == null || C == null) {
            throw new IllegalArgumentException();
        }
        if (area() <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        double centroidX = (A.getX() + B.getX() + C.getX()) / 3;
        double centroidY = (A.getY() + B.getY() + C.getY()) / 3;
        return new Point(centroidX, centroidY);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;                                //Same object -> is the same
        if (getClass() != figure.getClass()) return false;              //not the same types -> not the same
        if (!A.isTheSame(((Triangle) figure).A) &&
                !A.isTheSame(((Triangle) figure).B) &&
                !A.isTheSame(((Triangle) figure).C)) return false;
        if (!B.isTheSame(((Triangle) figure).A) &&
                !B.isTheSame(((Triangle) figure).B) &&
                !B.isTheSame(((Triangle) figure).C)) return false;
        return C.isTheSame(((Triangle) figure).A) ||
                C.isTheSame(((Triangle) figure).B) ||
                C.isTheSame(((Triangle) figure).C);
    }

    public double area() {
        return 0.5 * Math.abs((A.getX() - C.getX()) * (B.getY() - C.getY()) - (B.getX() - C.getX()) * (A.getY() - C.getY()));
    }
}
