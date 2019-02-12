package problem_solving.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContigousSubArrayWithGivenSum {

    public static void main(String[] args) {
        int sum = 21;
        int[] arr = new int[]{5, 4, 6, 7, 9, 8, 3, 1, 2};
        int[] arr2 = new int[]{8, 5, -2, 3, 4, -5, 7};

        findSubArrayWithGivenSumApproach1(arr, 45);
        findSubArrayWithGivenSumApproach2(arr2, 10);
    }

    private static void findSubArrayWithGivenSumApproach2(int[] arr, int sum) {
        final Map<Integer, Integer> map = new HashMap<>();

        int currentSum = 0;
        System.out.println("approach 2 => ");
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (map.get(currentSum - sum) != null) {
                final Integer start = map.get(currentSum - sum);
                System.out.println((start + 1) + "  " + i);
                break;
            } else {
                map.put(currentSum, i);
            }
        }
    }

    private static void findSubArrayWithGivenSumApproach1(int[] arr, int sum) {
        int length = arr.length;
        int start = 0;
        int currentSum = arr[0];

        System.out.println("approach 1 => ");

        int end = 1;
        // 5, 4, 6, 7, 9, 8, 3, 1, 2

        while (start < end) {
            if (currentSum > sum) {
                currentSum -= arr[start++];
            }
            if (currentSum == sum) {
                System.out.println(start + "  " + (end - 1));
                break;
            }
            if (currentSum < sum) {
                if (end < length) {
                    currentSum += arr[end];
                    end++;
                } else {
                    System.out.println("No subarray found with given sum " + sum);
                    break;
                }
            }
        }

    }
}
