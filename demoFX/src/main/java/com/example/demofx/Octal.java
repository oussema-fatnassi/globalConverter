package com.example.demofx;

import java.util.ArrayList;
import java.util.List;

public class Octal {                                                                                                    // Class to convert octal to ASCII

    public static int[] toAscii(String input) {                                                                         // Method to convert octal to ASCII
        input = input.replaceAll("\\s+", "");

        List<Integer> asciiList = new ArrayList<>();                                                                    // List to hold the ASCII values

        int i = 0;
        while (i < input.length()) {                                                                                    // Start processing the input string
            boolean validChunkFound = false;
            for (int chunkSize = 3; chunkSize > 0; chunkSize--) {                                                       // Attempt to parse chunks of 3, 2, or 1 digits
                if (i + chunkSize <= input.length()) {
                    String chunk = input.substring(i, i + chunkSize);
                    int asciiValue = octalToDecimal(chunk);
                    if (asciiValue >= 0 && asciiValue <= 255) {
                        asciiList.add(asciiValue);
                        i += chunkSize;
                        validChunkFound = true;
                        break;
                    }
                }
            }
            if (!validChunkFound) {                                                                                     // If no valid chunk was found, throw an exception
                throw new NumberFormatException("Invalid input: unable to parse valid ASCII values from input string");
            }
        }

        int[] asciiArray = new int[asciiList.size()];                                                                   // Convert the list to an array
        for (int j = 0; j < asciiArray.length; j++) {
            asciiArray[j] = asciiList.get(j);
        }

        return asciiArray;
    }

    public static int octalToDecimal(String octal) {                                                                    // Method to convert octal to decimal
        return Integer.parseInt(octal, 8);
    }
}
