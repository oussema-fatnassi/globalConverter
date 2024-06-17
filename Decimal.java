public class Decimal {                                              // Class to convert decimal to ASCII
    public static int[] toAscii(String input) {                     // Method to convert decimal to ASCII
        String[] decimalStrings = input.split(" ");
        int[] asciiArray = new int[decimalStrings.length];
        for (int i = 0; i < decimalStrings.length; i++) {
            int asciiValue = Integer.parseInt(decimalStrings[i]);
            asciiArray[i] = asciiValue;
        }
        return asciiArray;
    }

    public static void main(String[] args) {
        String decimalInput = "72 101 108 108 111";
        int[] asciiValues = toAscii(decimalInput);
        for (int ascii : asciiValues) {
            System.out.print((char) ascii);
        }
        System.out.println();
    }
}
