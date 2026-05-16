package org.example.ForRandomThings;

import java.util.Random;

public class ColorSupplier {

    public String getRandomColor() {
       int index = new Random().nextInt(Colors.values().length);
       return Colors.values()[index].toString().toLowerCase();
    }

    public enum Colors {
        RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE
    }
}
