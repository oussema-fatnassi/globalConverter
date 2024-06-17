public class Binary {
    public static int[] toAscii(String input) {
        int[] asciiArray = new int[input.length() / 8];
        for (int i = 0; i < input.length(); i += 8) {
            int endIndex = Math.min(i + 8, input.length());
            String chunk = input.substring(i, endIndex);
            int asciiValue = binaryToDecimal(chunk);
            asciiArray[i / 8] = asciiValue;
        }

        return asciiArray;
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        String binaryInput = "0100100001100101011011000110110001101111";
        int[] asciiValues = toAscii(binaryInput);
        for (int ascii : asciiValues) {
            System.out.print((char)ascii);
        }
        System.out.println();
    }
}
