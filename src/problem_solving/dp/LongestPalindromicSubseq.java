package problem_solving.dp;

public class LongestPalindromicSubseq {
    public static void main(String[] args) {
        String str = "raudra";
        findLongestPalindromicSubseq(str);
    }

    private static void findLongestPalindromicSubseq(String str) {
        final int length = str.length();
        int arr[][] = new int[length][length];

        for (int i = 0; i < length; i++) {
            arr[i][i] = 1;
        }
        for (int ls = 1; ls < length; ls++) { // length 2 -> strLength
            for (int i = 0; i < length - ls; i++) {
                int j = ls + i;
                if (str.charAt(i) == str.charAt(j)) {
                    if (ls == 1) {
                        arr[i][j] = 2;
                    } else {
                        arr[i][j] = arr[i + 1][j - 1] + 2;
                    }
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i + 1][j]);
                }
            }
        }
        System.out.println(arr[0][length - 1]);
    }
}
