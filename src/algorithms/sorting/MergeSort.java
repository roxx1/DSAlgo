package algorithms.sorting;

public class MergeSort {


    public static void main(String[] args) {
        int arr[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        doMergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " = ");
        }
    }

    public static void doMergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            doMergeSort(arr, p, q);
            doMergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    // merge p,q   q+1,r
    public static void merge(int[] arr, int p, int q, int r) {
        int L[] = new int[q - p + 2];
        int R[] = new int[r - q + 1];

        int j = 0, k = 0;

        for (int i = p; i <= q; i++) {
            L[j++] = arr[i];
        }
        L[j] = Integer.MAX_VALUE;

        j = 0;
        for (int i = q + 1; i <= r; i++) {
            R[j++] = arr[i];
        }
        R[j] = Integer.MAX_VALUE;

        j = 0;
        for (int i = p; i <= r; i++) {
            if (L[j] <= R[k]) {
                arr[i] = L[j];
                j++;
            } else if (R[k] < L[j]) {
                arr[i] = R[k];
                k++;
            }
        }
    }
}
