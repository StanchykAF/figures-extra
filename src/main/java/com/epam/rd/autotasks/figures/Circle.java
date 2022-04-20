package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point CENTRE;
    private final double RADIUS;

    public Circle(Point CENTRE, double RADIUS) {
        this.CENTRE = CENTRE;
        this.RADIUS = RADIUS;
        if (RADIUS <= 0 || this.CENTRE == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return CENTRE;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (this == figure) return true;                                //Same object -> is the same
        if (getClass() != figure.getClass()) return false;              //not the same types -> not the same
        double ERROR_DELTA = 0.0001;
        if (Math.abs(RADIUS - ((Circle) figure).RADIUS) >= ERROR_DELTA) return false;           //not same radii -> not the same
        return  (CENTRE.isTheSame(((Circle) figure).CENTRE));           //same centre point after all above -> is the same
    }
}
