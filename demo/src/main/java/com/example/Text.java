package com.example;
public class Text {                                     // Class to convert text to ASCII
    public static int[] toAscii(String input) {         // Method to convert text to ASCII
        int[] asciiArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            asciiArray[i] = (int) c;
        }
        return asciiArray;
    }
}
