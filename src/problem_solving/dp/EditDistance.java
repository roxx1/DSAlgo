package problem_solving.dp;

public class EditDistance {
    public static void main(String[] args) {
        String str1 = new String("DATE");
        String str2 = new String("DENT");
        findMinEditDistance(str1, str2);
    }

    private static void findMinEditDistance(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int ED[][] = new int[len1 + 1][len2 + 1];

        // Convert Str1 to Str2 with Min operations Insert, Replace, Delete
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) {
                    ED[i][j] = j;
                } else if (j == 0) {
                    ED[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ED[i][j] = ED[i - 1][j - 1];
                } else {
                    ED[i][j] = 1 + Math.min(ED[i - 1][j - 1], Math.min(ED[i - 1][j], ED[i][j - 1]));
                }
            }
        }
        System.out.println(ED[len1][len2]);
    }
}
