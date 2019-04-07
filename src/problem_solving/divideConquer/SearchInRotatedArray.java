package problem_solving.divideConquer;

import java.util.Arrays;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int arr[] = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 3, 4, 5, 6}; // sorted rotated array
        int k = 6;
        findEltInRotatedArrayApproach1(arr, k);
        int pos = findEltInRotatedArrayApproach2(arr, k, 0, arr.length - 1);
        System.out.println(pos);
    }

    private static int findEltInRotatedArrayApproach2(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[start] <= arr[mid]) { // first half sorted
            if (k >= arr[start] && k <= arr[mid]) {
                return Arrays.binarySearch(arr, start, mid + 1, k); // if elt present between first half
            } else {
                return findEltInRotatedArrayApproach2(arr, k, mid, end);
            }
        } else { // second half sorted
            if (k >= arr[mid] && k <= arr[end]) {
                return Arrays.binarySearch(arr, mid, end + 1, k); // if elt present between second half
            } else {
                return findEltInRotatedArrayApproach2(arr, k, start, mid);
            }
        }


    }

    private static void findEltInRotatedArrayApproach1(int[] arr, int k) {
        int pos;
        int pivot = findPivot(arr, 0, arr.length - 1);
        System.out.println(pivot);
        if (pivot == -1) {
            System.out.println("No Elt Present");
            return;
        }
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
