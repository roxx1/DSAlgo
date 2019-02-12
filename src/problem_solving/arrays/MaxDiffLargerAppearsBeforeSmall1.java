package problem_solving.arrays;

public class MaxDiffLargerAppearsBeforeSmall1 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 10, 2, 9, 1, 6};
        maxDiff(arr);
        maxDiffApproach2(arr);
    }

    private static void maxDiffApproach2(int[] arr) {
        int min_so_far = arr[0];
        int max_diff = Integer.MIN_VALUE;
        int x = 0, y = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min_so_far) {
                min_so_far = arr[i];
            } else {
                int current_diff = arr[i] - min_so_far;
                if (current_diff > max_diff) {
                    max_diff = current_diff;
                    x = min_so_far;
                    y = arr[i];
                }
            }
        }

        System.out.println(max_diff);

        System.out.println(x + "  " + y);

    }

    private static void maxDiff(int[] arr) {
        int[] largest = new int[arr.length];
        int[] smallest = new int[arr.length];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            smallest[i] = min;
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            }
            largest[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (max < largest[i] - smallest[i]) {
                max = largest[i] - smallest[i];
            }
        }

        System.out.println(max);
    }
}
