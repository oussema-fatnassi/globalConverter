import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Global Converter !!!");
        System.out.println("Choose in which format you want to enter the string:");
        System.out.println("hexadecimal (-h)");
        System.out.println("binary (-b)");
        System.out.println("octal (-o)");
        System.out.println("decimal (-d)");
        System.out.println("text (-t)");
        
        String choice = scanner.nextLine().trim().toLowerCase();

        switch (choice) {
            case "-h":
            case "hexadecimal":
                System.out.print("Enter a hexadecimal string: ");
                String hex = scanner.nextLine().trim(); 
                if (!InputVerification.isHexadecimal(hex)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                break;
            case "-b":
            case "binary":
                System.out.print("Enter a binary string: ");
                String bin = scanner.nextLine().trim();
                if (!InputVerification.isBinary(bin)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0 and 1.");
                }
                break;
            case "-o":
            case "octal":
                System.out.print("Enter an octal string: ");
                String oct = scanner.nextLine().trim();
                if(!InputVerification.isOctal(oct)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                break;
            case "-d":
            case "decimal":
                System.out.print("Enter a decimal string: ");
                String dec = scanner.nextLine();
                if (!InputVerification.isDecimal(dec)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9.");
                }
                break;
            case "-t":
            case "text":
                System.out.print("Enter a text string: ");
                String text = scanner.nextLine();
                if(!InputVerification.isText(text)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }

    public static boolean isValidInput(String input, String validCharacters) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!validCharacters.contains(String.valueOf(c))) {
                return false; 
            }
        }
        return true;
    }

}
