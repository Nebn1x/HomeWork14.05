package org.example;

import org.example.entity.Figure;
import org.example.randomthings.FigureSupplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ///////////////////////////////
        System.out.println("Part 1.1");
        FigureSupplier figureSupplier = new FigureSupplier();
        List<Figure> figureList = new ArrayList<>();
        Map<String, List<Figure>> mapOfFigures = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            figureList.add(figureSupplier.getRandomFigure());
        }

        for (Figure figure : figureList) {
            mapOfFigures.computeIfAbsent(figure.getClass().getSimpleName(), k -> new ArrayList<>()).add(figure);
        }

        for (Map.Entry<String, List<Figure>> entry : mapOfFigures.entrySet()) {
            System.out.println(entry.getKey() + ":");
            System.out.println("count = " + entry.getValue().size());
            System.out.println("total area = " + String.format("%.2f",entry.getValue().stream().mapToDouble(Figure::getArea).sum()));
        }

        ///////////////////////////////
        System.out.println("\nPart 1.2");
        Map<String, Set<Figure>> mapOfFiguresByColor = new HashMap<>();

        for (Figure figure : figureList) {
            mapOfFiguresByColor.computeIfAbsent(figure.getColor(), k -> new HashSet<>()).add(figure);
        }
        Set<Figure> testSet = new HashSet<>();
        testSet.add(figureSupplier.getDefaultFigure());
        testSet.add(figureSupplier.getDefaultFigure());
        System.out.println("testSet " + testSet.size());
        System.out.println("mapOfFiguresByColor " + mapOfFiguresByColor.size());

        //////////////////////////////
        System.out.println("\nPart 1.3");

        Comparator<Figure> comparator = Comparator.comparingDouble(Figure::getArea);
        List<Figure> sortedList = figureList.stream()
                .sorted(comparator.reversed())
                .limit(3)
                .toList();

        for (Figure figure : sortedList) {
            System.out.println(figure.getClass().getSimpleName() + ": " + figure.getColor() + ", area:" + String.format(" %.2f",figure.getArea()));
        }

        //////////////////////////////
        System.out.println("\nPart 1.4");

        Map<String, Double> mapForArea = new HashMap<>();
        Map<String, Integer> mapForCount = new HashMap<>();

        for (Figure figure : figureList) {
            mapForArea.merge(figure.getColor(), figure.getArea(), Double::sum);
            mapForCount.merge(figure.getColor(), 1, Integer::sum);
        }

        for (Map.Entry<String, Double> entry : mapForArea.entrySet()) {
            System.out.println(entry.getKey() + " average - " + String.format("%.2f",entry.getValue()/mapForCount.get(entry.getKey())));
        }

        //////////////////////////////
        System.out.println("\nPart 1.5");

        Map<String, List<Figure>> unmodifiableMap =
                Collections.unmodifiableMap(mapOfFigures);
        try {
            unmodifiableMap.put("Circle" , new ArrayList<>());
        } catch (UnsupportedOperationException e) {
            System.out.println("Unsupported operation");
            //unmodifiableMap не дає міняти обгортку
        }

        System.out.println("Before change :" + unmodifiableMap.get("Circle").size());

        mapOfFigures.get("Circle").add(figureSupplier.getRandomFigure());

        System.out.println("After change :" + unmodifiableMap.get("Circle").size());

        //все ще бачить зміни хоча не може сам поміняти
    }

}