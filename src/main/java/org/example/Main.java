package org.example;

import org.example.entity.Circle;
import org.example.entity.Figure;
import org.example.randomthings.FigureSupplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ///////////////////////////////
        System.out.println("Part 2.1");
        FigureSupplier figureSupplier = new FigureSupplier();
        List<Figure> figureList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            figureList.add(figureSupplier.getRandomFigure());
        }

        Predicate<Figure> isLarge = f -> f.getArea() > 50;
        Predicate<Figure> isRed = f -> f.getColor().equals("red");

        long countIsLarge = figureList.stream()
                .filter(isLarge)
                .count();
        System.out.println("Large figures - " + countIsLarge);

        long countIsLargeAndIsRed = figureList.stream()
                .filter(isLarge.and(isRed))
                        .count();
        System.out.println("Large and Red figures - " + countIsLargeAndIsRed);

        ///////////////////////////////
        System.out.println("Part 2.2");
        List<String> result2_2 = figureList.stream()
                .map(figure -> figure.getClass().getSimpleName()
                        + " "
                        + figure.getColor()
                        + " area= "
                        + String.format("%.2f",figure.getArea()))
                .toList();
        result2_2.forEach(System.out::println);

        ///////////////////////////////
        System.out.println("Part 2.3");
        Map<String, Long> result2_3 = figureList.stream()
                .collect(Collectors.groupingBy(figure -> figure.getClass().getSimpleName(),
                        Collectors.counting()
                ));
        result2_3.forEach((t, c) -> System.out.println("type- "+ t + ": " + "count = " + c));

        ///////////////////////////////
        System.out.println("Part 2.4");

        Optional<Figure> firstCircle = figureList.stream()
                .filter(figure -> figure instanceof Circle)
                .findFirst();

        String result = firstCircle
                .map(figure ->
                        figure.getClass().getSimpleName()
                                + " "
                                + figure.getColor()
                                + " area = "
                                + String.format("%.2f", figure.getArea()))
                .orElse("no circle");

        System.out.println(result);

        // список без Circle

        List<Figure> withoutCircles = new ArrayList<>(figureList);

        withoutCircles.removeIf(figure -> figure instanceof Circle);

        Optional<Figure> noCircle = withoutCircles.stream()
                .filter(figure -> figure instanceof Circle)
                .findFirst();

        String resultWithoutCircle = noCircle
                .map(figure ->
                        figure.getClass().getSimpleName()
                                +  figure.getColor()
                                + " area= "
                                + String.format("%.2f", figure.getArea()))
                .orElse("no circle");

        System.out.println(resultWithoutCircle);
    }
}