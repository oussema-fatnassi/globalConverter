import java.util.Scanner;
import java.util.Arrays;

public class Verification {
    public static void main(String[] args) {
        String Caracters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        java.util.Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Global Converter !!!");
        System.out.print("Enter a string: ");
        String n = sc.nextLine();
        
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (Caracters.contains(String.valueOf(c))) {
                System.out.println(c + " is in Caracters");
            } else {
                System.out.println(c + " is not in Caracters");
            }
        }

        int[] asciiArray = new int[n.length()];
        for (int i = 0; i < n.length(); i++) {
            asciiArray[i] = (int) n.charAt(i);
        }
        System.out.println("ASCII values of each character in " + n + ": " + Arrays.toString(asciiArray));

        System.out.println("Choose your conversion between hexadecimal, binary, octal and decimal: ");
        String choice = sc.nextLine();
        switch (choice) {
            case "hexadecimal":
                StringBuilder hexValue = new StringBuilder();
                for (int i = 0; i < n.length(); i++) {
                    hexValue.append(Integer.toHexString(asciiArray[i]));
                }
                System.out.println("The hexadecimal value of " + n + " is: " + hexValue.toString());
                break;
            case "binary":
                StringBuilder binaryValue = new StringBuilder();
                for (int i = 0; i < n.length(); i++) {
                    binaryValue.append(Integer.toBinaryString(asciiArray[i]));
                }
                System.out.println("The binary value of " + n + " is: " + binaryValue.toString());
                break;
            case "octal":
                StringBuilder octalValue = new StringBuilder();
                for (int i = 0; i < n.length(); i++) {
                    octalValue.append(Integer.toOctalString(asciiArray[i]));
                }
                System.out.println("The octal value of " + n + " is: " + octalValue.toString());
                break;
            case "decimal":
                StringBuilder decimalValue = new StringBuilder();
                for (int i = 0; i < n.length(); i++) {
                    decimalValue.append(asciiArray[i]);
                }
                System.out.println("The decimal value of " + n + " is: " + decimalValue.toString());
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }
}