package algorithms.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int arr[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        doSelectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " = ");
        }
    }

    private static void doSelectionSort(int[] arr) {
        int smallest;
        for (int i = 0; i < arr.length - 1; i++) {
            smallest = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            if (smallest != i)
                swap(arr, smallest, i);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
