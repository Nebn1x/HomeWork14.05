package org.example;

import org.example.entity.Figure;
import org.example.exeption.FigureNotFoundException;
import org.example.forRandomThings.FigureSupplier;
import org.example.entity.FigureStorage;
import org.example.service.MethodService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //        Figure[] figures = new Figure[6];

//        for (int i = 0; i < figures.length/2; i++) {
//            figures[i] = figureSupplier.getRandomFigure();
//        }
//
//        for (int i = figures.length/2; i < figures.length; i++) {
//            figures[i] = figureSupplier.getDefaultFigure();
//        }
//
//        for (Figure figure : figures) {
//            figure.draw();
//        }
        FigureSupplier figureSupplier = new FigureSupplier();
        MethodService methodService = new MethodService();
        final int NUMBER_OF_FIGURE = 10;

        FigureStorage<Figure> figureStorage = new FigureStorage<>();
        for (int i = 0; i < NUMBER_OF_FIGURE; i++) {
            figureStorage.add(figureSupplier.getRandomFigure());
        }

        try {
            for (int i = 0; i < NUMBER_OF_FIGURE+1; i++) {
                try {
                    figureStorage.getFigureById(i);
                } catch (FigureNotFoundException e) {
                    System.out.println(e.getMessage() + "\n");
                }
            }
        } catch (FigureNotFoundException e) {
           System.out.println(e.getMessage());
        }

        methodService.printDefaultMethods(figureStorage);

    }
}