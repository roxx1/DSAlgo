package problem_solving.dp;

public class MaxSumIncreasingSubseq {

    public static void main(String[] args) {
        int arr[] = new int[]{20, 3, 1, 15, 16, 2, 12, 13};
        printMaxSumIncreasingSubseq(arr);
    }

    private static void printMaxSumIncreasingSubseq(int[] arr) {
        int max_incr_sub_sum[] = new int[arr.length];
        max_incr_sub_sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && arr[i] + max_incr_sub_sum[j] > max) {
                    max = arr[i] + max_incr_sub_sum[j];
                }
            }
            max_incr_sub_sum[i] = max;
        }
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < max_incr_sub_sum.length; i++) {
            if (max_incr_sub_sum[i] > max_sum) {
                max_sum = max_incr_sub_sum[i];
            }
        }
        System.out.println(max_sum);
    }

}
