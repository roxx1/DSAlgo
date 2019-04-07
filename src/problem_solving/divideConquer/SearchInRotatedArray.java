package problem_solving.divideConquer;

import java.util.Arrays;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int arr[] = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 3, 4, 5, 6}; // sorted rotated array
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println(pivot);
        int k = 6, pos;
        if (pivot == arr.length - 1) {
            pos = Arrays.binarySearch(arr, k);
        } else {
            if (k > arr[pivot]) {
                pos = -1;
                System.out.println("No Elt Present");
            } else {
                if (k >= arr[0] && k <= arr[pivot]) {
                    pos = Arrays.binarySearch(arr, 0, pivot + 1, k);
                } else {
                    pos = Arrays.binarySearch(arr, pivot + 1, arr.length, k);
                }
            }
        }
        System.out.println(pos);
    }

    private static int findPivot(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (mid > 0 && (arr[mid] < arr[mid - 1])) {
            return mid - 1;
        }
        if (mid != arr.length - 1 && (arr[mid] > arr[mid + 1])) {
            return mid;
        }
        int x = findPivot(arr, start, mid - 1);
        if (x != -1) {
            return x;
        } else {
            return findPivot(arr, mid + 1, end);
        }
    }
}
