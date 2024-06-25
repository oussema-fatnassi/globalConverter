package com.example.demofx;

public class Ascii {                                                            // Class to convert ASCII to other formats

    public static String toDecimal(int[] asciiArray) {                          // Method to convert ASCII to decimal
        StringBuilder decimalString = new StringBuilder();
        for (int ascii : asciiArray) {
            decimalString.append(ascii).append(" ");
        }
        return decimalString.toString().trim();
    }

    public static String toHexadecimal(int[] asciiArray) {                      // Method to convert ASCII to hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (int ascii : asciiArray) {
            hexString.append(convertToHexadecimal(ascii)).append(" ");
        }
        return hexString.toString().trim();
    }

    public static String toOctal(int[] asciiArray) {                            // Method to convert ASCII to octal
        StringBuilder octalString = new StringBuilder();
        for (int ascii : asciiArray) {
            octalString.append(convertToOctal(ascii)).append(" ");
        }
        return octalString.toString().trim();
    }

    public static String toBinary(int[] asciiArray) {                           // Method to convert ASCII to binary
        StringBuilder binaryString = new StringBuilder();
        for (int ascii : asciiArray) {
            binaryString.append(convertToBinary(ascii)).append(" ");
        }
        return binaryString.toString().trim();
    }

    public static String toText(int[] asciiArray) {                             // Method to convert ASCII to text
        StringBuilder textString = new StringBuilder();
        for (int ascii : asciiArray) {
            textString.append((char) ascii);
        }
        return textString.toString();
    }

    private static String convertToBinary(int decimal) {                        // Method to convert decimal to binary
        StringBuilder binary = new StringBuilder();
        if (decimal == 0) {
            binary.append(0);
        } else {
            while (decimal != 0) {
                int remainder = decimal % 2;
                binary.insert(0, remainder);
                decimal = decimal / 2;
            }
            while (binary.length() % 8 != 0) {
                binary.insert(0, 0);
            }
        }
        return binary.toString();
    }

    private static String convertToHexadecimal(int decimal) {                   // Method to convert decimal to hexadecimal
        StringBuilder hexadecimal = new StringBuilder();
        if (decimal == 0) {
            hexadecimal.append(0);
        } else {
            while (decimal != 0) {
                int remainder = decimal % 16;
                if (remainder < 10) {
                    hexadecimal.insert(0, remainder);
                } else {
                    hexadecimal.insert(0, (char) ('A' + remainder - 10));
                }
                decimal = decimal / 16;
            }
        }
        return hexadecimal.toString();
    }

    private static String convertToOctal(int decimal) {                         // Method to convert decimal to octal
        StringBuilder octal = new StringBuilder();
        if (decimal == 0) {
            octal.append(0);
        } else {
            while (decimal != 0) {
                int remainder = decimal % 8;
                octal.insert(0, remainder);
                decimal = decimal / 8;
            }
        }
        return octal.toString();
    }
}
