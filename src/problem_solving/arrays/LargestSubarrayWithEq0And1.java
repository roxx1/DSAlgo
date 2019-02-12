package problem_solving.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEq0And1 {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1};
        findLargestSubarrayWithEq0And1(arr);
    }

    private static void findLargestSubarrayWithEq0And1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        final Map<Integer, Integer> map = new HashMap<>();

        // 1 1 1 -1 1 -1 -1 -1 1 1 1 1
        // max subarray with zero sum
        int sum = 0;
        int start = -1, end = -1;
        int maxDist = Integer.MIN_VALUE;
        Integer index;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            index = map.get(sum);
            if (index != null) {
                if (maxDist < i - (index + 1)) {
                    end = i;
                    start = index + 1;
                    maxDist = end - start;
                }
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(start + "  " + end);

    }
}
