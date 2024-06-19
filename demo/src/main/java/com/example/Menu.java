package com.example;

import java.util.Scanner;

public class Menu {
    public void MenuInstance() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("|             ASCII Converter                |");
            System.out.println("|   by Oussema F., Baptiste A., Ali A. I.    |");
            System.out.println("+--------------------------------------------+");
            System.out.println("| Please choose the starting format :        |");
            System.out.println("| 1. Decimal (-d)                            |");
            System.out.println("| 2. Hexadecimal (-h)                        |");
            System.out.println("| 3. Octal (-o)                              |");
            System.out.println("| 4. Binary (-b)                             |");
            System.out.println("| 5. Text (-t)                               |");
            System.out.println("| 6. Exit                                    |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Please choose an option: ");
            boolean validChoice = false;
            String untranslation = "";
            String translation = "";
            int[] asciiArray = new int[0];

            while (!validChoice) {
                String choice = scanner.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "-d":
                    case "1":
                    case "decimal":
                        System.out.print("Enter a decimal string: ");
                        String dec = scanner.nextLine();
                        while (!InputVerification.isDecimal(dec)) {
                            System.out.println("Invalid decimal string. Enter only 0-9.");
                            System.out.print("Enter a decimal string: ");
                            dec = scanner.nextLine();
                        }
                        dec = InputVerification.formatString(dec, 3);
                        asciiArray = Decimal.toAscii(dec);
                        untranslation = dec;
                        validChoice = true;
                        break;
                    case "-h":
                    case "2":
                    case "hexadecimal":
                        System.out.print("Enter a hexadecimal string: ");
                        String hex = scanner.nextLine().trim();
                        while (!InputVerification.isHexadecimal(hex)) {
                            System.out.println("Invalid hexadecimal string. Enter only 0-9 and A-F.");
                            System.out.print("Enter a hexadecimal string: ");
                            hex = scanner.nextLine().trim();
                        }
                        hex = InputVerification.formatString(hex, 2);
                        asciiArray = Hexadecimal.toAscii(hex);
                        untranslation = hex;
                        validChoice = true;
                        break;
                    case "-o":
                    case "3":
                    case "octal":
                        System.out.print("Enter an octal string: ");
                        String oct = scanner.nextLine().trim();
                        while (!InputVerification.isOctal(oct)) {
                            System.out.println("Invalid octal string. Enter only 0-7.");
                            System.out.print("Enter an octal string: ");
                            oct = scanner.nextLine().trim();
                        }
                        oct = InputVerification.formatString(oct, 3);
                        asciiArray = Octal.toAscii(oct);
                        untranslation = oct;
                        validChoice = true;
                        break;
                    case "-b":
                    case "4":
                    case "binary":
                        System.out.print("Enter a binary string: ");
                        String bin = scanner.nextLine().trim();
                        while (!InputVerification.isBinary(bin)) {
                            System.out.println("Invalid binary string. Enter only 0-1.");
                            System.out.print("Enter a binary string: ");
                            bin = scanner.nextLine().trim();
                        }
                        bin = InputVerification.formatString(bin, 8);
                        asciiArray = Binary.toAscii(bin);
                        untranslation = bin;
                        validChoice = true;
                        break;
                    case "-t":
                    case "5":
                    case "text":
                        System.out.print("Enter a text string: ");
                        String text = scanner.nextLine();
                        while (!InputVerification.isText(text)) {
                            System.out.println("Invalid text string. Enter only printable characters.");
                            System.out.print("Enter a text string: ");
                            text = scanner.nextLine();
                        }
                        asciiArray = Text.toAscii(text);
                        untranslation = text;
                        validChoice = true;
                        break;
                    case "exit":
                    case "6":
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

            translation = Ascii.toText(asciiArray);
            System.out.println();
            System.out.println("+--------------------------------------------+");
            System.out.println("| What do you want to do with your text?     |");
            System.out.println("| 1. Cipher                                  |");
            System.out.println("| 2. Decipher                                |");
            System.out.println("| 3. Convert                                 |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Please choose an option: ");

            boolean validChoice2 = false;
            boolean isCipher = false;
            boolean isDecipher = false;

            while (!validChoice2) {
                String choice2 = scanner.nextLine().trim().toLowerCase();
                switch (choice2) {
                    case "1":
                    case "cipher":
                        isCipher = true;
                        validChoice2 = true;
                        break;
                    case "2":
                    case "decipher":
                        isDecipher = true;
                        validChoice2 = true;
                        break;
                    case "3":
                    case "convert":
                        validChoice2 = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

            String cipherType = "None";
            String keyDetails = "None";

            if (isCipher) {
                System.out.println();
                System.out.println("+--------------------------------------------+");
                System.out.println("| Please choose the cipher type:             |");
                System.out.println("| 1. Caesar Cipher                           |");
                System.out.println("| 2. Vigenere Cipher                         |");
                System.out.println("| 3. Atbash Cipher                           |");
                System.out.println("+--------------------------------------------+");
                System.out.print("Please choose an option: ");

                boolean validChoice3 = false;

                while (!validChoice3) {
                    String choice3 = scanner.nextLine().trim().toLowerCase();
                    switch (choice3) {
                        case "1":
                        case "caesar cipher":
                            int shift;
                            while (true) {
                                try {
                                    System.out.print("Enter the shift value (must be a number): ");
                                    shift = Integer.parseInt(scanner.nextLine().trim());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Shift value must be a number.");
                                }
                            }
                            translation = Cipher.CeasarCipher(translation, shift);
                            cipherType = "Caesar Cipher";
                            keyDetails = "Shift: " + shift;
                            validChoice3 = true;
                            break;
                        case "2":
                        case "vigenere cipher":
                            System.out.print("Enter the key (must be a word): ");
                            String vigenereKey = scanner.nextLine().trim().toUpperCase();
                            while (!InputVerification.isText(vigenereKey)) {
                                System.out.println("Invalid key. Please enter a word.");
                                System.out.print("Enter the key: ");
                                vigenereKey = scanner.nextLine().trim().toUpperCase();
                            }
                            translation = Cipher.VigenereCipher(translation, vigenereKey);
                            cipherType = "Vigenere Cipher";
                            keyDetails = "Key: " + vigenereKey;
                            validChoice3 = true;
                            break;
                        case "3":
                        case "atbash cipher":
                            translation = Cipher.AtbashCipher(translation);
                            cipherType = "Atbash Cipher";
                            validChoice3 = true;
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            } else if (isDecipher) {
                System.out.println();
                System.out.println("+--------------------------------------------+");
                System.out.println("| Please choose the decipher type:           |");
                System.out.println("| 1. Caesar Decipher                         |");
                System.out.println("| 2. Vigenere Decipher                       |");
                System.out.println("| 3. Atbash Decipher                         |");
                System.out.println("+--------------------------------------------+");
                System.out.print("Please choose an option: ");

                boolean validChoice4 = false;

                while (!validChoice4) {
                    String choice4 = scanner.nextLine().trim().toLowerCase();
                    switch (choice4) {
                        case "1":
                        case "caesar decipher":
                            int shift;
                            while (true) {
                                try {
                                    System.out.print("Enter the shift value (must be a number): ");
                                    shift = Integer.parseInt(scanner.nextLine().trim());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Shift value must be a number.");
                                }
                            }
                            translation = Cipher.CeasarDecipher(translation, shift);
                            cipherType = "Caesar Decipher";
                            keyDetails = "Shift: " + shift;
                            validChoice4 = true;
                            break;
                        case "2":
                        case "vigenere decipher":
                            System.out.print("Enter the key (must be a word): ");
                            String vigenereKey = scanner.nextLine().trim().toUpperCase();
                            while (!InputVerification.isText(vigenereKey)) {
                                System.out.println("Invalid key. Please enter a word.");
                                System.out.print("Enter the key: ");
                                vigenereKey = scanner.nextLine().trim().toUpperCase();
                            }
                            translation = Cipher.VigenereDecipher(translation, vigenereKey);
                            cipherType = "Vigenere Decipher";
                            keyDetails = "Key: " + vigenereKey;
                            validChoice4 = true;
                            break;
                        case "3":
                        case "atbash decipher":
                            translation = Cipher.AtbashDecipher(translation);
                            cipherType = "Atbash Decipher";
                            validChoice4 = true;
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            }

            asciiArray = Text.toAscii(translation);

            System.out.println();
            System.out.println("+--------------------------------------------+");
            System.out.println("| Please choose the target format :          |");
            System.out.println("| 1. Decimal (-d)                            |");
            System.out.println("| 2. Hexadecimal (-h)                        |");
            System.out.println("| 3. Octal (-o)                              |");
            System.out.println("| 4. Binary (-b)                             |");
            System.out.println("| 5. Text (-t)                               |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Please choose an option: ");

            boolean validChoice5 = false;

            while (!validChoice5) {
                String choice5 = scanner.nextLine().trim().toLowerCase();
                switch (choice5) {
                    case "-d":
                    case "1":
                    case "decimal":
                        translation = Ascii.toDecimal(asciiArray);
                        validChoice5 = true;
                        break;
                    case "-h":
                    case "2":
                    case "hexadecimal":
                        translation = Ascii.toHexadecimal(asciiArray);
                        validChoice5 = true;
                        break;
                    case "-o":
                    case "3":
                    case "octal":
                        translation = Ascii.toOctal(asciiArray);
                        validChoice5 = true;
                        break;
                    case "-b":
                    case "4":
                    case "binary":
                        translation = Ascii.toBinary(asciiArray);
                        validChoice5 = true;
                        break;
                    case "-t":
                    case "5":
                    case "text":
                        translation = Ascii.toText(asciiArray);
                        validChoice5 = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            System.out.println();
            System.out.println("+--------------------------------------------+");
            System.out.println("| Original: " + untranslation);
            System.out.println("| Translation: " + translation);
            System.out.println("| Cipher Type: " + cipherType);
            System.out.println("| Key Details: " + keyDetails);
            System.out.println("+--------------------------------------------+");
            System.out.println("| Press ENTER to continue                    |");
            System.out.println("+--------------------------------------------+");
            scanner.nextLine();
            try {
                String os = System.getProperty("os.name").toLowerCase();
                ProcessBuilder processBuilder;
                if (os.contains("win")) {
                    processBuilder = new ProcessBuilder("cmd", "/c", "cls");
                } else {
                    processBuilder = new ProcessBuilder("clear");
                }
                processBuilder.inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println("Error while clearing the screen.");
            }
        }
    }
}
