package data_structures.heap;

public class MinHeap {

    public static void createMinHeap(int arr[]) {
        int heapSize = arr.length;
        final int n = Math.floorDiv(arr.length, 2);
        for (int i = n - 1; i >= 0; i--) {
            buildMinHeap(arr, heapSize, i);
        }
    }

    public static void buildMinHeap(int arr[], int heapSize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < heapSize && arr[left] < arr[i]) {
            smallest = left;
        }
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            buildMinHeap(arr, heapSize, smallest);
        }
    }

    public static int extractMin(int arr[]) {
        int min = arr[0];
        arr[arr.length - 1] = Integer.MAX_VALUE;
        buildMinHeap(arr, arr.length, 0);
        return min;
    }

    public static void decreaseKey(int arr[], int i, int value) {
        if (arr[i] < value) {
            return;
        }
        arr[i] = value;
        while(i>=0 && arr[i]<arr[i/2]) {
            int temp = arr[i];
            arr[i] = arr[i/2];
            arr[i/2] = temp;
            i=i/2;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        createMinHeap(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " = ");
        }
        System.out.println();
        decreaseKey(arr,5,-1);

        System.out.println(extractMin(arr));

    }
}
