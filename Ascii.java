public class Ascii {
    public static String toDecimal(int[] asciiArray) {
        StringBuilder decimalString = new StringBuilder();
        for (int ascii : asciiArray) {
            decimalString.append(ascii).append(" ");
        }
        return decimalString.toString().trim();
    }

    public static String toHexadecimal(int[] asciiArray) {
        StringBuilder hexString = new StringBuilder();
        for (int ascii : asciiArray) {
            hexString.append(Integer.toHexString(ascii)).append(" ");
        }
        return hexString.toString().trim();
    }

    public static String toOctal(int[] asciiArray) {
        StringBuilder octalString = new StringBuilder();
        for (int ascii : asciiArray) {
            octalString.append(Integer.toOctalString(ascii)).append(" ");
        }
        return octalString.toString().trim();
    }

    public static String toBinary(int[] asciiArray) {
        StringBuilder binaryString = new StringBuilder();
        for (int ascii : asciiArray) {
            binaryString.append(Integer.toBinaryString(ascii)).append(" ");
        }
        return binaryString.toString().trim();
    }

    public static String toText(int[] asciiArray) {
        StringBuilder textString = new StringBuilder();
        for (int ascii : asciiArray) {
            textString.append((char) ascii);
        }
        return textString.toString();
    }

    public static void main(String[] args) {
        int[] asciiArray = {72, 101, 108, 108, 111};

        System.out.println("Decimal: " + toDecimal(asciiArray));
        System.out.println("Hexadecimal: " + toHexadecimal(asciiArray));
        System.out.println("Octal: " + toOctal(asciiArray));
        System.out.println("Binary: " + toBinary(asciiArray));
        System.out.println("Text: " + toText(asciiArray));
    }
}
