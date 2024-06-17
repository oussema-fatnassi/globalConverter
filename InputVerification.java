public class InputVerification {

    public static boolean isBinary(String input) {
        return input.matches("[01]+");
    }

    public static boolean isOctal(String input) {
        return input.matches("[0-7]+"); 
    }

    public static boolean isHexadecimal(String input) {
        return input.matches("[0-9A-Fa-f]+"); 
    }

    public static boolean isDecimal(String input) {
        return input.matches("[0-9]+"); 
    }

    public static boolean isText(String input) {
        return input.matches("[a-zA-Z0-9 ]+"); 
    }
}
