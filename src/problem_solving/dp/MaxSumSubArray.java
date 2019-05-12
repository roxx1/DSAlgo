package problem_solving.dp;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-3, 10, 5, -20, 4, 11, -5, 7};
        printMaxSumSubArray(arr);
    }

    private static void printMaxSumSubArray(int[] arr) {
        int max_sum_so_far = Integer.MIN_VALUE;
        int curr_sum = 0;
        int end_index = -1;

        for (int i = 0; i < arr.length; i++) {
            curr_sum += arr[i];
            if (curr_sum < 0) {
                curr_sum = 0;
            }
            if (curr_sum > max_sum_so_far) {
                max_sum_so_far = curr_sum;
                end_index = i;
            }
        }
        int sum = 0, start_index = -1;
        for (int i = end_index; i >= 0; i--) {
            sum += arr[i];
            if (sum == max_sum_so_far) {
                start_index = i; // start index
                break;
            }
        }

        System.out.println(max_sum_so_far);
        System.out.println(start_index + "," + end_index);
    }
}
