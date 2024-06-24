package com.example.demofx;

public class ConversionResult {                                                                                         // Class to store the result of a conversion

    private int[] asciiArray;
    private String errorMessage;

    public ConversionResult(int[] asciiArray, String errorMessage) {                                                    // Constructor  to initialize the ASCII array and error message
        this.asciiArray = asciiArray;
        this.errorMessage = errorMessage;
    }

    public int[] getAsciiArray() {                                                                                      // Method to get the ASCII array
        return asciiArray;
    }

    public String getErrorMessage() {                                                                                   // Method to get the error message
        return errorMessage;
    }
}
