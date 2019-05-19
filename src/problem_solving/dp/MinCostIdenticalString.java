package problem_solving.dp;

public class MinCostIdenticalString {
    public static void main(String[] args) {
        // min cost to convert 1 string to another by deleting (cost of deleting 1 char in 1 string is S and another is P)
        String str1 = "RAVI";
        String str2 = "AIBC";
        int s = 1;
        int p = 2;
        calculateMinCostOfConverting(str1, str2, s, p);
    }

    private static void calculateMinCostOfConverting(String str1, String str2, int s, int p) {
        int arr[][] = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            arr[i][0] = i * s;
        }

        for (int i = 1; i <= str2.length(); i++) {
            arr[0][i] = i * p;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.min(arr[i - 1][j] + s, arr[i][j - 1] + p);
                }
            }
        }
        for (int i = 0; i <= str1.length(); i++) {
            System.out.println();
            for (int j = 0; j <= str2.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
}
