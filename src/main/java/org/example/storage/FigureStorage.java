package org.example.storage;

import org.example.entity.Figure;
import org.example.exception.FigureNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FigureStorage <T extends Figure> {

    private final List<T> figures;

    public FigureStorage() {
        figures = new ArrayList<>();
    }

    public void add(T figure) {
        figures.add(figure);
    }

    public List<T> getFigures() {
        return Collections.unmodifiableList(figures);
    }

    public T getById(int index) {
        if (index < 0 || index >= figures.size()) {
            throw new FigureNotFoundException("Figure #" + index + " not found");
        }
        return figures.get(index);
    }

    public int size () {
      return figures.size();
    }
}

