package com.epam.rd.autotasks.figures;

class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isTheSame(Point point) {
        if (this == point) return true;
        if (getClass() != point.getClass()) return false;
        double ERROR_DELTA = 0.0001;
        if (Math.abs(x - point.getX()) >= ERROR_DELTA) return false;
        return  Math.abs(y - point.getY()) < ERROR_DELTA;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
