package problem_solving.dp;

public class MaxSum2ByNRectangle {
    public static void main(String[] args) {
        int arr[][] = new int[][]{{1, 2, 3, 4, 6}, {0, 5, 2, 1, 7}};
        findMaxSumNoTwoRowsAdjacent(arr);
    }

    private static void findMaxSumNoTwoRowsAdjacent(int[][] arr) {
        int d[] = new int[arr[0].length];
        d[0] = Math.max(arr[0][0], arr[1][0]);
        d[1] = Math.max(d[0], Math.max(arr[0][1], arr[1][1]));

        for (int i = 2; i < d.length; i++) {
            int inc = d[i - 2] + Math.max(arr[0][i], arr[1][i]);
            int exc = d[i - 1];
            d[i] = Math.max(inc, exc);
        }
        System.out.println(d[d.length - 1]);
    }
}
