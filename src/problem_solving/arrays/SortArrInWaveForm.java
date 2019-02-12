package problem_solving.arrays;

import java.util.Arrays;

public class SortArrInWaveForm {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr2 = new int[]{20, 8, 10, 6, 4, 2};
        sortArrInWaveFormApproch2(arr);
        System.out.println();
        sortArrInWaveFormApproch1(arr);
    }

    private static void sortArrInWaveFormApproch1(int[] arr) {
        Arrays.sort(arr); // 1,2,3,4,5,6,7,8   => 2 1 4 3 6 5 8 7
        for (int i = 0; i < arr.length; i = i + 2) {
            SwapUtils.swapNos(arr, i, i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " => ");
        }
    }

    private static void sortArrInWaveFormApproch2(int[] arr) {
        // 8,6,7,4,5,2,3,1
        for (int i = 1; i < arr.length - 1; i = i + 2) { // odd elem pos should be min

            if (arr[i] > arr[i - 1]) {
                SwapUtils.swapNos(arr, i, i - 1);
            }

            if (arr[i] > arr[i + 1]) {
                SwapUtils.swapNos(arr, i, i + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " => ");
        }
    }
}
