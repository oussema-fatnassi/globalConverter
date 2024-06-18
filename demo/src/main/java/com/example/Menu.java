package com.example;
import java.util.Scanner;

public class Menu {
    public void MenuInstance() {                                                        // Method to display the menu
        java.util.Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("+--------------------------------------------+");
            System.out.println("|             ASCII Converter                |");
            System.out.println("|   by Oussema F., Baptiste A., Ali A. I.    |");
            System.out.println("+--------------------------------------------+");
            System.out.println("|Please choose the starting format :         |");
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
                String choice = scanner.nextLine().trim().toLowerCase();                        // User inputs
                switch (choice) {                                                               // Switch case to check the user input and chose the appropriate method
                    case "-h":
                    case"2":
                    case "hexadecimal":                                                         // If user enters hexadecimal
                        System.out.print("Enter a hexadecimal string: ");
                        String hex = scanner.nextLine().trim(); 
                        while (!InputVerification.isHexadecimal(hex)) {                         // Check if the input is valid
                            System.out.println("Invalid hexadecimal string. Enter only 0-9 and A-F.");
                            System.out.print("Enter a hexadecimal string: ");
                            hex = scanner.nextLine().trim();
                        }
                        asciiArray = Hexadecimal.toAscii(hex);
                        untranslation = hex;
                        validChoice = true;
                        break;
                    case "-b":
                    case"4":
                    case "binary":                                                              // If user enters binary
                        System.out.print("Enter a binary string: ");
                        String bin = scanner.nextLine().trim();
                        while (!InputVerification.isBinary(bin)) {                             // Check if the input is valid
                            System.out.println("Invalid binary string. Enter only 0-1.");
                            System.out.print("Enter a binary string: ");
                            bin = scanner.nextLine().trim();
                        }
                        asciiArray = Binary.toAscii(bin);
                        untranslation = bin;
                        validChoice = true;
                        break;
                    case "-o":
                    case"3":
                    case "octal":                                                               // If user enters octal
                        System.out.print("Enter an octal string: ");
                        String oct = scanner.nextLine().trim();
                        while (!InputVerification.isOctal(oct)) {                              // Check if the input is valid
                            System.out.println("Invalid octal string. Enter only 0-7.");
                            System.out.print("Enter an octal string: ");
                            oct = scanner.nextLine().trim();
                        }
                        asciiArray = Octal.toAscii(oct);
                        untranslation = oct;
                        validChoice = true;
                        break;
                    case "-d":
                    case"1":
                    case "decimal":                                                             // If user enters decimal
                        System.out.print("Enter a decimal string: ");
                        String dec = scanner.nextLine();
                        while (!InputVerification.isDecimal(dec)) {                            // Check if the input is valid
                            System.out.println("Invalid decimal string. Enter only 0-9.");
                            System.out.print("Enter a decimal string: ");
                            dec = scanner.nextLine();
                        }
                        asciiArray = Decimal.toAscii(dec);
                        untranslation = dec;
                        validChoice = true;
                        break;
                    case "-t":
                    case"5":
                    case "text":                                                                // If user enters text
                        System.out.print("Enter a text string: ");
                        String text = scanner.nextLine();
                        while (!InputVerification.isText(text)) {                               // Check if the input is valid
                            System.out.println("Invalid text string. Enter only printable characters.");
                            System.out.print("Enter a text string: ");
                            text = scanner.nextLine();
                        }
                        asciiArray = Text.toAscii(text);
                        untranslation = text;
                        validChoice = true;
                        break;
                    case "exit":                                                                // If user wants to exit
                    case"6":
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            
            System.out.println("+--------------------------------------------+");
            System.out.println("|Please choose the target format :           |");
            System.out.println("| 1. Decimal (-d)                            |");
            System.out.println("| 2. Hexadecimal (-h)                        |");
            System.out.println("| 3. Octal (-o)                              |");
            System.out.println("| 4. Binary (-b)                             |");
            System.out.println("| 5. Text (-t)                               |");
            System.out.println("+--------------------------------------------+");
            System.out.print("Please choose an option: ");

            boolean validChoice2 = false;

            while (!validChoice2) {
                String choice2 = scanner.nextLine().trim().toLowerCase();
                switch (choice2) {                                                              // Switch case to check the user input and chose the appropriate method
                    case "-h":
                    case "2":
                    case "hexadecimal":                                                         // If user chooses hexadecimal 
                        translation = Ascii.toHexadecimal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-b":
                    case "4":
                    case "binary":                                                              // If user chooses binary
                        translation = Ascii.toBinary(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-o":
                    case "3":
                    case "octal":                                                               // If user chooses octal
                        translation = Ascii.toOctal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-d":
                    case "1":
                    case "decimal":                                                             // If user chooses decimal
                        translation = Ascii.toDecimal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-t":
                    case "5":
                    case "text":                                                                // If user chooses text 
                        translation = Ascii.toText(asciiArray);
                        validChoice2 = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            System.out.println("Your untranslated string is: " + untranslation);           // Display the unstranslated string
            System.out.println("The translation is: " + translation);                       // Display the translation
            System.out.println("Press Enter to continue...");
            String wait = scanner.nextLine();
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();      // Clear the screen
            } catch (Exception e) {
                System.out.println("Error while clearing the screen.");
            }
        }
    }
}
