package problem_solving.dp;

import java.util.Arrays;

public class EqualPartitionProblem {

    public static void main(String[] args) {
        int arr[] = new int[]{4, 10, 5, 15, 3, 1};
        findIfEqualPartitionPossible(arr);
    }

    private static void findIfEqualPartitionPossible(int[] arr) {
        // check if Array can be Equally Divided
        final int sum = Arrays.stream(arr).sum() / 2; // check if Half Sum can be computed by summing

        boolean partition[][] = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            partition[0][i] = false;
        }

        for (int i = 1; i <= arr.length; i++) {
            partition[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                partition[i][j] = partition[i - 1][j] || partition[i - 1][sum - j];
            }
        }
        System.out.println(partition[arr.length][sum]);
    }
}