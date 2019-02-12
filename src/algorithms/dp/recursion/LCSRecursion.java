package algorithms.dp.recursion;

public class LCSRecursion {

    public static void main(String[] args) {
        String str1 = "ABCDEF";
        String str2 = "ADA";
        int x = calculateLongestCommonSubsequence(str1, str2, str1.length(), str2.length());
        System.out.println(x);
    }

    private static int calculateLongestCommonSubsequence(String str1, String str2, int l1, int l2) {

        if (l1 == 0 || l2 == 0) return 0;

        if (str1.charAt(l1 - 1) == str2.charAt(l2 - 1)) {
            return calculateLongestCommonSubsequence(str1, str2, l1 - 1, l2 - 1) + 1;
        } else {
            return Math.max(calculateLongestCommonSubsequence(str1, str2, l1 - 1, l2), calculateLongestCommonSubsequence(str1, str2, l1, l2 - 1));
        }

    }

}
