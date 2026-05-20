package org.example.randomthings;

import org.example.entity.Circle;
import org.example.entity.Figure;
import org.example.entity.IsoscelesTrapezoid;
import org.example.entity.Rectangle;
import org.example.entity.RightTriangle;
import org.example.entity.Square;

import java.util.Random;

public class FigureSupplier {

    private final ColorSupplier colorSupplier = new ColorSupplier();
    private final Random rand = new Random();
    private final Figures[] figuresArray = Figures.values();

    public Figure getRandomFigure() {
        int index = rand.nextInt(figuresArray.length);
        switch (figuresArray[index]) {
            case SQUARE:
                return new Square(colorSupplier.getRandomColor(), rand.nextInt(10));
            case RECTANGLE:
                return new Rectangle(colorSupplier.getRandomColor(), rand.nextInt(10), rand.nextInt(10));
            case RIGHT_TRIANGLE:
                return new RightTriangle(colorSupplier.getRandomColor(), rand.nextInt(10), rand.nextInt(10));
            case CIRCLE:
                return new Circle(colorSupplier.getRandomColor(), rand.nextInt(10));
            case ISOSCELES_TRAPEZOID:
                return new IsoscelesTrapezoid(colorSupplier.getRandomColor(), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10));
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
