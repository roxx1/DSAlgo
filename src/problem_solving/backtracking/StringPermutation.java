package problem_solving.backtracking;

public class StringPermutation {

    public static void main(String[] args) {
        String str = "ABC";
        permute(str, 0, str.length() - 1);
    }

    private static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        }

        for (int i = start; i <= end; i++) {
            str = swap(str, start, i);
            permute(str, start + 1, end);
            str = swap(str, start, i);
        }

    }

    private static String swap(String str, int i, int j) {
        final char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
