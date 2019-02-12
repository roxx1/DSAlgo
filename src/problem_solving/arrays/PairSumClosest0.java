package problem_solving.arrays;

import java.util.Arrays;

public class PairSumClosest0 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 9, 6, 1, 3, -5};

        findPairHavingSumClosestToZero(arr);
    }

    private static void findPairHavingSumClosestToZero(int[] arr) {
        Arrays.sort(arr); // -5 -2 1 2 6 9
        int i = 0;
        int k, j = arr.length - 1;
        int x = 0, y = 0, min_sum = Integer.MAX_VALUE;

        while (i < j) {
            k = arr[i] + arr[j];
            int diff = Math.abs(k);

            if (diff < min_sum) {
                x = arr[i];
                y = arr[j];
                min_sum = diff;
            }

            if (k == 0) {
                break;
            }

            if (k < 0) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(x + "  " + y);
        System.out.println(min_sum);

    }

}
