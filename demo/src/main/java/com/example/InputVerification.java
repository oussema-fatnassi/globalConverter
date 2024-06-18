package com.example;
public class InputVerification {                        // Class to verify the input for each type of input
    public static boolean isBinary(String input) {
        return input.matches("[01\\s]+");
    }

    public static boolean isOctal(String input) {
        return input.matches("[0-7\\s]+"); 
    }

    public static boolean isHexadecimal(String input) {
        return input.matches("[0-9A-Fa-f\\s]+"); 
    }

    public static boolean isDecimal(String input) {
        return input.matches("[0-9\\s]+"); 
    }

    public static boolean isText(String input) {
        return input.matches("[a-zA-Z0-9\\s]+"); 
    }
}
