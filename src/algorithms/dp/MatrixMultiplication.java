package algorithms.dp;

public class MatrixMultiplication {


    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 1, 4, 1};

        int m[][] = new int[arr.length][arr.length];

        int minCost = calculateMinCost(arr, m);

        System.out.println("minCost " + minCost);

    }

    // O(n2) * O(n) = O(n3)

    public static int calculateMinCost(int[] p, int[][] m) {

        int n = p.length;   // n = 5
        int sum = 0;

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;

                m[i][j] = Integer.MAX_VALUE;
                System.out.println("i => " + i + " j => " + j);
                for (int k = i; k < j - i; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        sum += q;
                    }
                }
            }
        }
        return sum;
    }

}
