package problem_solving.arrays;

import java.util.Arrays;

public class NoOfPossibleTriangles {

    public static void main(String[] args) {
        int arr[] = new int[]{6, 7, 8, 10, 12, 14, 50};
        calculatePossibleTriangles(arr);
    }

    private static void calculatePossibleTriangles(int[] arr) {
        int i, j, k;
        int total = 0;

        Arrays.sort(arr);

        for (k = arr.length - 1; k > 1; k--) {
            i = 0;
            j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    total += j - i;
                    j--;
                } else {
                    i++;
                }
            }

        }

        System.out.println(total);

    }

}
