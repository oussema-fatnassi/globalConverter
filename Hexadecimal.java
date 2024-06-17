public class Hexadecimal {                                      // Class to convert hexadecimal to ASCII
    public static int[] toAscii(String input) {                 // Method to convert hexadecimal to ASCII
        int[] asciiArray = new int[input.length() / 2];
        for (int i = 0; i < input.length(); i += 2) {
            int endIndex = Math.min(i + 2, input.length());
            String chunk = input.substring(i, endIndex);
            int asciiValue = hexToDecimal(chunk);
            asciiArray[i / 2] = asciiValue;
        }
        return asciiArray;
    }

    public static int hexToDecimal(String hex) {                // Method to convert hexadecimal to decimal
        return Integer.parseInt(hex, 16);
    }

    public static void main(String[] args) {
        String hexInput = "48656c6c6f"; 
        int[] asciiValues = toAscii(hexInput);
        for (int ascii : asciiValues) {
            System.out.print((char)ascii);
        }
        System.out.println();
    }
}
