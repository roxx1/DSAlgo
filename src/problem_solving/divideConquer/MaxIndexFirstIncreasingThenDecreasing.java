package problem_solving.divideConquer;

public class MaxIndexFirstIncreasingThenDecreasing {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 10, 11, 12, 13, 14, 20, 7, 8, 9};
        int index = findIndexFirstIncreasingThenDecreasing(arr, 0, arr.length - 1);
        int index2 = findIndexFirstIncreasingThenDecreasingApproach2(arr, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int findIndexFirstIncreasingThenDecreasingApproach2(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            return mid;
        }
        if (mid > 0 && arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findIndexFirstIncreasingThenDecreasingApproach2(arr, mid + 1, end);
        } else {
            return findIndexFirstIncreasingThenDecreasingApproach2(arr, start, mid);
        }
    }

    private static int findIndexFirstIncreasingThenDecreasing(int[] arr, int start, int end) {

        if (start == end) {
            return arr[start];
        }
        if (end == start + 1) {
            return Math.max(arr[start], arr[end]);
        }

        int mid = (start + end) / 2;
        if (mid > 0 && mid < arr.length - 1 && (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])) {
            return mid;
        }

        if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            return findIndexFirstIncreasingThenDecreasing(arr, start, mid - 1);
        } else {
            return findIndexFirstIncreasingThenDecreasing(arr, mid + 1, end);
        }

    }
}
