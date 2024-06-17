public class Text {
    public static int[] toAscii (String input) {
        int[] asciiArray = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            asciiArray[i] = (int) c;
        }
        return asciiArray;
    }
}