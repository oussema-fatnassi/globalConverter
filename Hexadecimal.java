public class Hexadecimal {                                      
    public static int[] toAscii(String input) {                 
        // Split the input string by spaces
        String[] hexArray = input.split("\\s+");
        int[] asciiArray = new int[hexArray.length];
        
        for (int i = 0; i < hexArray.length; i++) {
            String chunk = hexArray[i];
            int asciiValue = hexToDecimal(chunk);
            asciiArray[i] = asciiValue;
        }
        
        return asciiArray;
    }

    public static int hexToDecimal(String hex) {                
        return Integer.parseInt(hex, 16);
    }

    public static void main(String[] args) {
        String hexInput = "48 65 6c 6c 6f"; 
        int[] asciiValues = toAscii(hexInput);
        for (int ascii : asciiValues) {
            System.out.print((char)ascii);
        }
        System.out.println();
    }
}
