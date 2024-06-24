package com.example.demofx;

public class Binary {                                                                                                   // Class to convert binary to ASCII

    public static int[] toAscii(String input) {
        input = input.replaceAll("\\s+", "");                                                         // Remove any spaces from the input string

        int chunkSize = 8;                                                                                              // Split the input into chunks of 8 characters
        int numChunks = (int) Math.ceil(input.length() / (double) chunkSize);
        int[] asciiArray = new int[numChunks];

        for (int i = 0; i < numChunks; i++) {                                                                           // Convert each chunk to an ASCII value
            String chunk = input.substring(i * chunkSize, Math.min(input.length(), (i + 1) * chunkSize));
            asciiArray[i] = binaryToDecimal(chunk);
        }

        return asciiArray;
    }

    private static int binaryToDecimal(String binary) {                                                                 // Method to convert binary to decimal
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += (int) Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }
}