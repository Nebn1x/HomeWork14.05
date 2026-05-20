package org.example.entity;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class IsoscelesTrapezoid extends Figure {

    private final int base1;
    private final int base2;
    private final int height;

    public IsoscelesTrapezoid(String color, int base1, int base2, int height) {
        super(color);
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (double) (base1 + base2) / 2 * height;
    }

    @Override
    public void draw() {
        System.out.println(
                "Figure: isosceles trapezoid, " +
                        "area: " + String.format("%.2f", getArea()) + " sq. units, " +
                        "base1: " + base1 + " units, " +
                        "base2: " + base2 + " units, " +
                        "height: " + height + " units, " +
                        "color: " + getColor()
        );
    }
}
