package com.example.demofx;

public class Binary {

    public static int[] toAscii(String input) {
        // Remove any spaces from the input string
        input = input.replaceAll("\\s+", "");

        // Split the input into chunks of 8 bits
        int chunkSize = 8;
        int numChunks = (int) Math.ceil(input.length() / (double) chunkSize);
        int[] asciiArray = new int[numChunks];

        for (int i = 0; i < numChunks; i++) {
            String chunk = input.substring(i * chunkSize, Math.min(input.length(), (i + 1) * chunkSize));
            asciiArray[i] = binaryToDecimal(chunk);
        }

        return asciiArray;
    }

    private static int binaryToDecimal(String binary) {
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