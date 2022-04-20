package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Segment {
    private final double xStart;
    private final double xEnd;
    private final double yStart;
    private final double yEnd;

    public Segment(Point start, Point end) {
        xStart = start.getX();
        xEnd = end.getX();
        yStart = start.getY();
        yEnd = end.getY();
        if ((xStart == xEnd) && (yStart == yEnd)) {
            throw new IllegalArgumentException();
        }
    }

    Point intersection(Segment another) {
        double k = (xStart - xEnd) * (another.yStart - another.yEnd) - (yStart - yEnd) * (another.xStart - another.xEnd);
        double t, u;
        if (k == 0) {
            return null;
        }
        t = ((xStart - another.xStart) * (another.yStart - another.yEnd) - (yStart - another.yStart) * (another.xStart - another.xEnd)) / k;
        u = ((xStart - another.xStart) * (yStart - yEnd) - (yStart - another.yStart) * (xStart - xEnd)) / k;
        if ((t < 0 || t > 1) || (u < 0 || u > 1)) {
            return null;
        }
        return new Point(xStart + t * (xEnd - xStart), yStart + t * (yEnd - yStart));
    }

}


