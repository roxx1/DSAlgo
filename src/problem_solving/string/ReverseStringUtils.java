package problem_solving.string;

public class ReverseStringUtils {

    private ReverseStringUtils() {
        throw new AssertionError();
    }

    public static void reverse(StringBuilder str, int i, int j) {
        while (i < j) {
            char c = str.charAt(j);
            str.setCharAt(j, str.charAt(i));
            str.setCharAt(i, c);
            i++;
            j--;
        }
    }
}
