package org.example.ForRandomThings;

import org.example.Entity.Circle;
import org.example.Entity.Figure;
import org.example.Entity.IsoscelesTrapezoid;
import org.example.Entity.Rectangle;
import org.example.Entity.RightTriangle;
import org.example.Entity.Square;

import java.util.Random;

public class FigureSupplier {

    ColorSupplier colorSupplier = new ColorSupplier();
    private final Random rand = new Random();

    public Figure getRandomFigure() {
        int index = rand.nextInt(FigureSupplier.Figures.values().length);
        switch (FigureSupplier.Figures.values()[index]) {
            case SQUARE:
                return new Square(colorSupplier.getRandomColor(), rand.nextDouble(100));
            case RECTANGLE:
                return new Rectangle(colorSupplier.getRandomColor(), rand.nextDouble(100), rand.nextDouble(100));
            case RIGHT_TRIANGLE:
                return new RightTriangle(rand.nextDouble(100), rand.nextDouble(100), colorSupplier.getRandomColor());
            case CIRCLE:
                return new Circle(colorSupplier.getRandomColor(), rand.nextDouble(100));
            case ISOSCELES_TRAPEZOID:
                return new IsoscelesTrapezoid(colorSupplier.getRandomColor(), rand.nextDouble(100), rand.nextDouble(100), rand.nextDouble(100));
            default:
                return getDefaultFigure();
        }
    }

    public Figure getDefaultFigure() {
        return new Circle("white", 10);
    }

    private enum Figures {
        SQUARE, RECTANGLE, RIGHT_TRIANGLE, CIRCLE, ISOSCELES_TRAPEZOID
    }
}
