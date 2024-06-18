package com.example;
import java.util.Scanner;

public class Menu {
    public void MenuInstance() {                                                        // Method to display the menu
        java.util.Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Global Converter !!!");                    // Welcome message and choice of first language
            System.out.println("Choose in which format you want to enter the string:");
            System.out.println("hexadecimal (-h)");
            System.out.println("binary (-b)");
            System.out.println("octal (-o)");
            System.out.println("decimal (-d)");
            System.out.println("text (-t)");
            System.out.println("Type 'exit' to quit the program.");
            boolean validChoice = false;
            String translation = ""; 
            int[] asciiArray = new int[0];

            while (!validChoice) {
                String choice = scanner.nextLine().trim().toLowerCase();                        // User inputs
                switch (choice) {                                                               // Switch case to check the user input and chose the appropriate method
                    case "-h":
                    case "hexadecimal":                                                         // If user enters hexadecimal
                        System.out.print("Enter a hexadecimal string: ");
                        String hex = scanner.nextLine().trim(); 
                        if (!InputVerification.isHexadecimal(hex)) {
                            System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                        } else {
                            asciiArray = Hexadecimal.toAscii(hex);
                        }
                        validChoice = true;
                        break;
                    case "-b":
                    case "binary":                                                              // If user enters binary
                        System.out.print("Enter a binary string: ");
                        String bin = scanner.nextLine().trim();
                        if (!InputVerification.isBinary(bin)) {
                            System.out.println("Invalid binary string. Enter only 0 and 1.");
                        } else {
                            asciiArray = Binary.toAscii(bin);
                        }
                        validChoice = true;
                        break;
                    case "-o":
                    case "octal":                                                               // If user enters octal
                        System.out.print("Enter an octal string: ");
                        String oct = scanner.nextLine().trim();
                        if(!InputVerification.isOctal(oct)) {
                            System.out.println("Invalid octal string. Enter only 0-7.");
                        } else {
                            asciiArray = Octal.toAscii(oct);
                        }
                        validChoice = true;
                        break;
                    case "-d":
                    case "decimal":                                                             // If user enters decimal
                        System.out.print("Enter a decimal string: ");
                        String dec = scanner.nextLine();
                        if (!InputVerification.isDecimal(dec)) {
                            System.out.println("Invalid decimal string. Enter only 0-9.");
                        } else {
                            asciiArray = Decimal.toAscii(dec);
                        }
                        validChoice = true;
                        break;
                    case "-t":
                    case "text":                                                                // If user enters text
                        System.out.print("Enter a text string: ");
                        String text = scanner.nextLine();
                        if(!InputVerification.isText(text)) {
                            System.out.println("Invalid text string. Enter only alphanumeric characters.");
                        } else {
                            asciiArray = Text.toAscii(text);
                        }
                        validChoice = true;
                        break;
                    case "exit":                                                                // If user wants to exit
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            
            System.out.println("Choose another format you want to translate to: ");       // User chooses the format to convert to 
            System.out.println("hexadecimal (-h)");
            System.out.println("binary (-b)");
            System.out.println("octal (-o)");
            System.out.println("decimal (-d)");
            System.out.println("text (-t)");
            boolean validChoice2 = false;

            while (!validChoice2) {
                String choice2 = scanner.nextLine().trim().toLowerCase();
                switch (choice2) {                                                              // Switch case to check the user input and chose the appropriate method
                    case "-h":
                    case "hexadecimal":                                                         // If user chooses hexadecimal 
                        translation = Ascii.toHexadecimal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-b":
                    case "binary":                                                              // If user chooses binary
                        translation = Ascii.toBinary(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-o":
                    case "octal":                                                               // If user chooses octal
                        translation = Ascii.toOctal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-d":
                    case "decimal":                                                             // If user chooses decimal
                        translation = Ascii.toDecimal(asciiArray);
                        validChoice2 = true;
                        break;
                    case "-t":
                    case "text":                                                                // If user chooses text 
                        translation = Ascii.toText(asciiArray);
                        validChoice2 = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
            System.out.println("The translation is: " + translation);                       // Display the translation
        }
    }
}
