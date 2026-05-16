package org.example.Entity;

public class Rectangle extends Figure {

    private final int width;
    private final int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public void draw() {
        System.out.println(
                "Figure: rectangle, " +
                        "area: " + String.format("%.2f", getArea()) + " sq. units, " +
                        "width: " + width + " units, " +
                        "height: " + height + " units, " +
                        "color: " + getColor()
        );
    }
}
