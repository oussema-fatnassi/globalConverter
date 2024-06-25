package com.example;
public class Decimal {                                              // Class to convert decimal to ASCII
    public static int[] toAscii(String input) {                     // Method to convert decimal to ASCII
        String[] decimalStrings = input.split(" ");
        int[] asciiArray = new int[decimalStrings.length];
        for (int i = 0; i < decimalStrings.length; i++) {
            int asciiValue = Integer.parseInt(decimalStrings[i]);
            asciiArray[i] = asciiValue;
        }
        return asciiArray;
    }
}
