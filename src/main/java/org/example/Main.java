package org.example;

import org.example.entity.Figure;
import org.example.exception.FigureNotFoundException;
import org.example.forRandomThings.FigureSupplier;
import org.example.entity.FigureStorage;
import org.example.service.MethodService;

public class Main {
    public static void main(String[] args) {
        FigureSupplier figureSupplier = new FigureSupplier();
        MethodService methodService = new MethodService();
        final int NUMBER_OF_FIGURE = 10;

        FigureStorage<Figure> figureStorage = new FigureStorage<>();
        for (int i = 0; i < NUMBER_OF_FIGURE; i++) {
            figureStorage.add(figureSupplier.getRandomFigure());
        }

        for (int i = 0; i < NUMBER_OF_FIGURE+1; i++) {
            try {
                figureStorage.getFigureById(i);
            } catch (FigureNotFoundException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

        methodService.printDefaultMethods(figureStorage);

    }
}