package com.example.demofx;

public class Hexadecimal {                                                                                              // Class to convert hexadecimal to ASCII

    public static int[] toAscii(String input) {
        input = input.replaceAll("\\s+", "");                                                         // Remove any spaces from the input string

        int chunkSize = 2;                                                                                              // Split the input into chunks of 2 characters (each hex digit pair represents a byte)
        int numChunks = (int) Math.ceil(input.length() / (double) chunkSize);
        int[] asciiArray = new int[numChunks];

        for (int i = 0; i < numChunks; i++) {                                                                           // Convert each chunk to an ASCII value
            String chunk = input.substring(i * chunkSize, Math.min(input.length(), (i + 1) * chunkSize));
            int asciiValue = hexToDecimal(chunk);
            asciiArray[i] = asciiValue;
        }

        return asciiArray;
    }

    public static int hexToDecimal(String hex) {                                                                        // Method to convert hexadecimal to decimal
        return Integer.parseInt(hex, 16);
    }
}
