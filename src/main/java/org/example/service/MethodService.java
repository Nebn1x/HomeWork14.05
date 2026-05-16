package org.example.service;

import org.example.annotations.DefaultArea;
import org.example.entity.Figure;

import java.lang.reflect.Method;
import java.util.List;

public class MethodService {

        public void printDefaultMethods (List<? extends Figure> figures) {
            for (Figure figure : figures) {
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
