package com.example.demofx;

public class ConversionResult {
    private int[] asciiArray;
    private String errorMessage;

    public ConversionResult(int[] asciiArray, String errorMessage) {
        this.asciiArray = asciiArray;
        this.errorMessage = errorMessage;
    }

    public int[] getAsciiArray() {
        return asciiArray;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
