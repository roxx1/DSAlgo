package problem_solving.arrays;

public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 15, 3, 4, 21, 2};
        findEquilIndex(arr);
    }

    private static void findEquilIndex(int[] arr) {
        int[] leftSum = new int[arr.length];
        int[] rightSum = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            leftSum[i] = sum;
        }

        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            rightSum[i] = sum;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (leftSum[i] == rightSum[i + 1]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
