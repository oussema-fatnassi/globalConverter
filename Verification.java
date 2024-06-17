import java.util.Scanner;

public class Verification {
    public static void main(String[] args) {
        String Caracters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
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
        sc.close();
    }
}