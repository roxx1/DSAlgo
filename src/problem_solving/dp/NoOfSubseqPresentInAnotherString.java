package problem_solving.dp;

public class NoOfSubseqPresentInAnotherString {
    public static void main(String[] args) {
        String s1 = "abbab";
        String s2 = "ab";
        countNoOfSubseqPresent(s1, s2);
    }

    private static void countNoOfSubseqPresent(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int arr[][] = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len2; i++) {
            arr[0][i] = 0;
        }

        for (int i = 0; i <= len1; i++) {
            arr[i][0] = 1; // no of empty subseq in a ab abb abba abbab = 1
        }


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= s1.length(); i++) {
            System.out.println();
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
