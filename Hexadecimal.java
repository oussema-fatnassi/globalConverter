public class Hexadecimal {                                      
    public static int[] toAscii(String input) {                 
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
}
