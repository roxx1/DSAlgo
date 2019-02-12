package algorithms.dp;

public class LCS {

    private static String str1 = "AAACCGTGAGTTATTCGTTCTAGAA";
    private static String str2 = "CACCCCTAAGGTACCTTTGGTTC";

    public static void main(String[] args) {

        int[][] x = calculateLCSLength(str1, str2, str1.length(), str2.length());
        System.out.println(x[str1.length()][str2.length()]);

        final String str = calculateLCS(x, str1.length(), str2.length());
        System.out.println(str);
    }

    private static int[][] calculateLCSLength(String str1, String str2, int m, int n) {
        int lcs[][] = new int[m + 1][n + 1];
        // O(n*m)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        lcs[i][j] = 1 + lcs[i - 1][j - 1];
                    } else {
                        lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
                    }
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(lcs[i][j] + " ");
            }
            System.out.println();
        }

        return lcs;
    }

    private static String calculateLCS(int[][] lcs, int m, int n) {
        StringBuilder str = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            final boolean b = str1.charAt(i - 1) == str2.charAt(j - 1);
            if (b) {
                str.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (lcs[i][j - 1] < lcs[i - 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return str.reverse().toString();
    }
}