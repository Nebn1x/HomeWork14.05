package org.example.Entity;

public class RightTriangle extends Figure {

    private final double leg1;
    private final double leg2;

    public RightTriangle(double leg1, double leg2, String color) {
        super(color);
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    @Override
    public double getArea() {
        return (leg1 * leg2) / 2;
    }

    @Override
    public void draw() {
        System.out.println(
                "Figure: right triangle, " +
                        "area: " + String.format("%.2f", getArea()) + " sq. units, " +
                        "firstLeg: " + leg1 + " units, " +
                        "secondLeg: " + leg2 + " units, " +
                        "color: " + getColor()
        );
    }
}
