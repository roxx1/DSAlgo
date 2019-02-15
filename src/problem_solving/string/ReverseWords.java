package problem_solving.string;

public class ReverseWords {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("This is a Class");
        reverseWordsInString(str);
    }

    private static void reverseWordsInString(StringBuilder str) {
        int i = 0;
        for (int j = i + 1; j <= str.length(); j++) {
            if (j == str.length() || str.charAt(j) == ' ') {
                ReverseStringUtils.reverse(str, i, j - 1);
                i = j + 1;
            }
        }

        ReverseStringUtils.reverse(str, 0, str.length() - 1);
        System.out.println(str.toString());
    }
}