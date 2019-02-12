package algorithms.dp;

public class DPKnapsack01 {

    public static void main(String[] args) {
        int p[] = new int[]{10, 12, 28};
        int[] weight = new int[]{1, 2, 4};
        int capacity = 6;

        int maxProfit = calculateMaxProfit(p, weight, capacity, weight.length);
        System.out.println(maxProfit);
    }

    private static int calculateMaxProfit(int[] p, int[] weight, int capacity, int n) {

        int ks[][] = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) { // max profit with i elements having capacity j
                if (i == 0 || j == 0) {
                    ks[i][j] = 0;
                } else {
                    if (j >= weight[i - 1]) {
                        ks[i][j] = Math.max(p[i - 1] + ks[i - 1][j - weight[i - 1]], ks[i - 1][j]);
                    } else {
                        ks[i][j] = ks[i - 1][j];
                    }
                }
            }

        }
        return ks[n][capacity];
    }

}
