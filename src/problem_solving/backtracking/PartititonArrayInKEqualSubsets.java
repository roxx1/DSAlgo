package problem_solving.backtracking;

import java.util.stream.IntStream;

public class PartititonArrayInKEqualSubsets {

    static int arr[] = {2, 1, 4, 5, 6};  // 6
    static int k = 3;


    public static void main(String[] args) {
        final boolean checkPartitionAllowed = checkPartitionAllowed(arr, k);
        if (checkPartitionAllowed) {
            boolean[] visited = new boolean[arr.length];
            final boolean partitionPossible = isPartitionPossible(0, k, 0, IntStream.of(arr).sum() / k, visited);
            System.out.println(partitionPossible);
        }
    }

    private static boolean isPartitionPossible(int start, int k, int currSum, int targetSum, boolean[] visited) {
        if (k == 1)
            return true;

        if (currSum == targetSum) {
            return isPartitionPossible(0, k - 1, 0, targetSum, visited);
        }
// [2,1,4,5,6]
        for (int i = start; i < arr.length; i++) {
            if (visited[i] == false && currSum + arr[i] <= targetSum) {
                visited[i] = true;
                boolean b = isPartitionPossible(start + 1, k, currSum + arr[i], targetSum, visited);
                if (b) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    private static boolean checkPartitionAllowed(int[] arr, int k) {
        final int sum = IntStream.of(arr).sum();
        return k > 0 && sum % k == 0;
    }
}
