public class Text {                                     // Class to convert text to ASCII
    public static int[] toAscii(String input) {         // Method to convert text to ASCII
        int[] asciiArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            asciiArray[i] = (int) c;
        }
        return asciiArray;
    }

    public static void main(String[] args) {
        String textInput = "Hello"; 
        int[] asciiValues = toAscii(textInput);
        for (int ascii : asciiValues) {
            System.out.print(ascii + " ");
        }
        System.out.println();
    }
}
