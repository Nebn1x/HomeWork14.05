package org.example.forRandomThings;

import java.util.Random;

public class ColorSupplier {

    private final Random rand = new Random();
    private final Colors[] arrayColors = Colors.values();

    public String getRandomColor() {
       int index = rand.nextInt(arrayColors.length);
       return arrayColors[index].toString().toLowerCase();
    }

    private enum Colors {
        RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE
    }
}
