package com.example;

public class Cypher {
    
    public static String CeasarCypher(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
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

    public static String CeasarDecypher(String text, int shift) {
        return CeasarCypher(text, 26 - shift);
    }

    public static String VigenereCypher(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
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

    public static String VigenereDecypher(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
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

}
