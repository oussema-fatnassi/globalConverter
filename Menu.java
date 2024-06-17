import java.util.Scanner;

public class Menu {
    public void MenuInstance() {
        java.util.Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Global Converter !!!");
        System.out.println("Choose in which format you want to enter the string:");
        System.out.println("hexadecimal (-h)");
        System.out.println("binary (-b)");
        System.out.println("octal (-o)");
        System.out.println("decimal (-d)");
        System.out.println("text (-t)");
        
        String choice = scanner.nextLine().trim().toLowerCase();
        int[] asciiArray = new int[0];
        String translation = ""; 

        switch (choice) {
            case "-h":
            case "hexadecimal":
                System.out.print("Enter a hexadecimal string: ");
                String hex = scanner.nextLine().trim(); 
                if (!InputVerification.isHexadecimal(hex)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                asciiArray=Hexadecimal.toAscii(hex);
                break;
            case "-b":
            case "binary":
                System.out.print("Enter a binary string: ");
                String bin = scanner.nextLine().trim();
                if (!InputVerification.isBinary(bin)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0 and 1.");
                }
                asciiArray=Binary.toAscii(bin);
                break;
            case "-o":
            case "octal":
                System.out.print("Enter an octal string: ");
                String oct = scanner.nextLine().trim();
                if(!InputVerification.isOctal(oct)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                asciiArray=Octal.toAscii(oct);
                break;
            case "-d":
            case "decimal":
                System.out.print("Enter a decimal string: ");
                String dec = scanner.nextLine();
                if (!InputVerification.isDecimal(dec)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9.");
                }
                asciiArray=Decimal.toAscii(dec);
                break;
            case "-t":
            case "text":
                System.out.print("Enter a text string: ");
                String text = scanner.nextLine();
                if(!InputVerification.isText(text)) {
                    System.out.println("Invalid hexadecimal string. Enter only 0-9A-Fa-f.");
                }
                asciiArray=Text.toAscii(text);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        
        System.out.println("Choose another format you want to translate to: ");
        System.out.println("hexadecimal (-h)");
        System.out.println("binary (-b)");
        System.out.println("octal (-o)");
        System.out.println("decimal (-d)");
        System.out.println("text (-t)");

        String choice2 = scanner.nextLine().trim().toLowerCase();
        switch (choice2) {
            case "-h":
            case "hexadecimal":
                translation = Ascii.toHexadecimal(asciiArray);
                break;
            case "-b":
            case "binary":
                translation = Ascii.toBinary(asciiArray);
                break;
            case "-o":
            case "octal":
                translation = Ascii.toOctal(asciiArray);
                break;
            case "-d":
            case "decimal":
                translation = Ascii.toDecimal(asciiArray);
                break;
            case "-t":
            case "text":
                translation = Ascii.toText(asciiArray);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        System.out.println("The translation is: " + translation);
        scanner.close();
    }
}
