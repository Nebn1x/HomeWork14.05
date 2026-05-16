package org.example.entity;

public class Circle extends Figure {

    private final int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public void draw() {
        System.out.println(
                "Figure: circle, " +
                        "area: " + String.format("%.2f", getArea()) + " sq. units, " +
                        "radius: " + radius + " units, " +
                        "color: " + getColor()
        );
    }
}
