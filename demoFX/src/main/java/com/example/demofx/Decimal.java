package com.example.demofx;

import java.util.ArrayList;
import java.util.List;

public class Decimal {

    public static int[] toAscii(String input) {
        // Remove any spaces from the input string
        input = input.replaceAll("\\s+", "");

        // List to hold the ASCII values
        List<Integer> asciiList = new ArrayList<>();

        // Start processing the input string
        int i = 0;
        while (i < input.length()) {
            // Attempt to parse chunks of 1, 2, or 3 digits
            boolean validChunkFound = false;
            for (int chunkSize = 3; chunkSize > 0; chunkSize--) {
                if (i + chunkSize <= input.length()) {
                    String chunk = input.substring(i, i + chunkSize);
                    long asciiValue = Long.parseLong(chunk);
                    if (asciiValue >= 0 && asciiValue <= 255) {
                        asciiList.add((int) asciiValue);
                        i += chunkSize;
                        validChunkFound = true;
                        break;
                    }
                }
            }
            if (!validChunkFound) {
                throw new NumberFormatException("Invalid input: unable to parse valid ASCII values from input string");
            }
        }

        // Convert the list to an array
        int[] asciiArray = new int[asciiList.size()];
        for (int j = 0; j < asciiArray.length; j++) {
            asciiArray[j] = asciiList.get(j);
        }

        return asciiArray;
    }
}
