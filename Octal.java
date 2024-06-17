public class Octal {                                            // Class to convert octal to ASCII
    public static int[] toAscii(String input) {                 // Method to convert octal to ASCII
        int[] asciiArray = new int[input.length() / 3];
        for (int i = 0; i < input.length(); i += 3) {
            int endIndex = Math.min(i + 3, input.length());
            String chunk = input.substring(i, endIndex);
            int asciiValue = octalToDecimal(chunk);
            asciiArray[i / 3] = asciiValue;
        }
        return asciiArray;
    }

    public static int octalToDecimal(String octal) {            // Method to convert octal to decimal
        return Integer.parseInt(octal, 8);
    }

    public static void main(String[] args) {
        String octalInput = "110145154154157";
        int[] asciiValues = toAscii(octalInput);
        for (int ascii : asciiValues) {
            System.out.print((char) ascii);
        }
        System.out.println();
    }
}
