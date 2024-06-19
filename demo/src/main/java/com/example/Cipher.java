package com.example;

public class Cipher {                                                           // Class to perform various ciphers and deciphering
    
    public static String CeasarCipher(String text, int shift) {                 // Method to perform Caesar cipher on the text       
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                        // If the character is a letter, shift it forward       
                if (Character.isLowerCase(c)) {
                    result += (char) ('a' + (c - 'a' + shift) % 26);
                } else {
                    result += (char) ('A' + (c - 'A' + shift) % 26);
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    public static String CeasarDecipher(String text, int shift) {               // Method to perform Caesar decipher on the text
        return CeasarCipher(text, 26 - shift);
    }

    public static String VigenereCipher(String text, String key) {              // Method to perform Vigenere cipher on the text
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                        // If the character is a letter, shift it forward    
                int shift = key.charAt(keyIndex) - 'a';
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + (c - 'a' + shift) % 26));
                } else {
                    result.append((char) ('A' + (c - 'A' + shift) % 26));
                }
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }

    public static String VigenereDecipher(String text, String key) {            // Method to perform Vigenere decipher on the text
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                        // If the character is a letter, shift it back          
                int shift = key.charAt(keyIndex) - 'a';
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + (c - 'a' - shift + 26) % 26));
                } else {
                    result.append((char) ('A' + (c - 'A' - shift + 26) % 26));
                }
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }

    public static String AtbashCipher(String text) {                            // Method to perform Atbash cipher on the text
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = Character.isUpperCase(c) ? (char) ('Z' - (c - 'A')) : (char) ('z' - (c - 'a'));
                result.append(encryptedChar);
            } else if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                int encryptedDigit = 9 - digit;                                 // For digits, it's just the reverse order
                result.append(encryptedDigit);
            } else {
                result.append(c);                                               // Non-letter characters remain unchanged
            }
        }
        return result.toString();
    }

    public static String AtbashDecipher(String text) {                          // Method to perform Atbash decipher on the text    
        return AtbashCipher(text);                                              // Atbash is its own inverse
    }

}
