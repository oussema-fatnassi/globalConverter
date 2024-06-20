package com.example.demofx;
public class Binary {                                               // Class to convert binary to ASCII
    public static int[] toAscii(String input) {                     // Method to convert binary to ASCII
        String[] binaryArray = input.split("\\s+");
        int[] asciiArray = new int[binaryArray.length];
        for (int i = 0; i < binaryArray.length; i ++) {
            String chunk = binaryArray[i];
            int asciiValue = binaryToDecimal(chunk);
            asciiArray[i] = asciiValue;
        }
        return asciiArray;
    }

    public static int binaryToDecimal(String binary) {              // Method to convert binary to decimal
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}
