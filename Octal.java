public class Octal {                                            // Class to convert octal to ASCII
    public static int[] toAscii(String input) {                 // Method to convert octal to ASCII
        // Split the input string by spaces
        String[] octalArray = input.split("\\s+");
        int[] asciiArray = new int[octalArray.length];
        
        for (int i = 0; i < octalArray.length; i++) {
            String chunk = octalArray[i];
            int asciiValue = octalToDecimal(chunk);
            asciiArray[i] = asciiValue;
        }
        
        return asciiArray;
    }

    public static int octalToDecimal(String octal) {            // Method to convert octal to decimal
        return Integer.parseInt(octal, 8);
    }

    public static void main(String[] args) {
        String octalInput = "110 105 114 114 117"; 
        int[] asciiValues = toAscii(octalInput);
        for (int ascii : asciiValues) {
            System.out.print((char) ascii);
        }
        System.out.println();
    }
}
