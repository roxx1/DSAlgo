package algorithms.sorting;

public class QuickSort {

    public static void doQuickSort(int[] arr, int p, int r) {
        if (p < r) {
            int pivot = doPartition(arr, p, r);
            doQuickSort(arr, p, pivot - 1);
            doQuickSort(arr, pivot + 1, r);
        }
    }

    public static int doPartition(int[] arr, int p, int r) {
            int i = p - 1, j, temp;
            int key = arr[r];
            for (j = p; j < r; j++) {
                if (arr[j] <= key) {
                    i++;
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            temp = arr[i + 1];
            arr[i + 1] = arr[r];
            arr[r] = temp;
            return i + 1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};

        doQuickSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " = ");
        }
    }

}
