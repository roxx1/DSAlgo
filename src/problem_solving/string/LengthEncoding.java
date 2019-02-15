package problem_solving.string;

public class LengthEncoding {

    public static void main(String[] args) {
        String str = compressString("SMMMARRRRTTT");
        System.out.println(str);
    }

    private static String compressString(String str) {
        int i = 0, j = 0;

        StringBuilder newStr = new StringBuilder();

        while (j < str.length()) {
            int count = 0;

            final char c = str.charAt(i);

            while (j < str.length() && c == str.charAt(j)) {
                count++;
                j++;
            }

            newStr.append(c).append(count);

            i = j;

        }

        return newStr.toString();
    }

}
