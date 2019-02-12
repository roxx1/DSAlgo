package problem_solving.arrays;

import java.util.HashSet;
import java.util.Set;

public class PairOfNum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 4, 5, 6, 7};
        findPairOfNos(arr, 6);
    }

    private static void findPairOfNos(int[] arr, int sum) {

        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (set.contains(temp)) {
                System.out.println(arr[i] + "  " + (sum - arr[i]));
            }
            set.add(arr[i]);
        }
    }
}
