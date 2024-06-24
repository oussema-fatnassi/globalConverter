package com.example.demofx;

public class Cipher {                                                                                                   // Class to perform various ciphers and deciphering
    
    public static String CaesarCipher(String text, int shift) {                                                         // Method to perform Caesar cipher on the text
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                                                                // If the character is a letter, shift it forward
                if (Character.isLowerCase(c)) {
                    result.append((char) ('a' + (c - 'a' + shift) % 26));
                } else {
                    result.append((char) ('A' + (c - 'A' + shift) % 26));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String CaesarDecipher(String text, int shift) {                                                       // Method to perform Caesar decipher on the text
        return CaesarCipher(text, 26 - shift);
    }

    public static String VigenereCipher(String text, String key) {                                                      // Method to perform Vigenere cipher on the text
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {                                                                       // Iterate through each character in the text
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                                                                // If the character is a letter, shift it forward
                int shift = key.charAt(keyIndex) - 'a';
                if (Character.isLowerCase(c)) {                                                                         // If the character is lowercase, shift it forward
                    result.append((char) ('a' + (c - 'a' + shift) % 26));                                               // Modulus 26 to wrap around the alphabet
                } else {
                    result.append((char) ('A' + (c - 'A' + shift) % 26));                                               // If the character is uppercase, shift it forward
                }
                keyIndex = (keyIndex + 1) % key.length();                                                               // Move to the next character in the key
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }

    public static String VigenereDecipher(String text, String key) {                                                    // Method to perform Vigenere decipher on the text
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {                                                                                // If the character is a letter, shift it back
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

    public static String AtbashCipher(String text) {                                                                    // Method to perform Atbash cipher on the text
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = Character.isUpperCase(c) ? (char) ('Z' - (c - 'A')) : (char) ('z' - (c - 'a'));
                result.append(encryptedChar);
            } else if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                int encryptedDigit = 9 - digit;                                                                         // For digits, it's just the reverse order
                result.append(encryptedDigit);
            } else {
                result.append(c);                                                                                       // Non-letter characters remain unchanged
            }
        }
        return result.toString();
    }

    public static String AtbashDecipher(String text) {                                                                  // Method to perform Atbash decipher on the text
        return AtbashCipher(text);                                                                                      // Atbash is its own inverse
    }
}