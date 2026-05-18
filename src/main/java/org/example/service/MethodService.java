package org.example.service;

import org.example.annotations.DefaultArea;
import org.example.entity.Figure;
import org.example.entity.FigureStorage;

import java.lang.reflect.Method;


public class MethodService {

        public void printDefaultMethods (FigureStorage<Figure> figureStorage) {
            for (Figure figure : figureStorage.getFigures()) {
                Class<?> clazz = figure.getClass();
                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(DefaultArea.class)) {
                        System.out.println("Class: " + clazz.getSimpleName());
                        System.out.println(" - Method: " + method.getName());
                        System.out.println();
                    }
                }
            }
        }
}
