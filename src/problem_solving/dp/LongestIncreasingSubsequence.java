package problem_solving.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = new int[]{21, 10, 3, 11, 14, 25, 6, 7};
        printLongestIncreasingSubseq(arr);
    }

    private static void printLongestIncreasingSubseq(int[] arr) {
        int lis[] = new int[arr.length];
        Arrays.fill(lis, 1);
        int max;
        for (int i = 1; i < lis.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, lis[j] + 1);
                }
            }
            lis[i] = Math.max(lis[i], max);
        }
        max = Integer.MIN_VALUE;
        for (int t : lis) {
            max = Math.max(t, max);
        }
        System.out.println(max);
    }
}
