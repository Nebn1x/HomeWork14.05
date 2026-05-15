package org.example.entity;

public abstract class Figure {
    private final String color;

    protected Figure(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract void draw();

    public String getColor() {
        return color;
    }
}
