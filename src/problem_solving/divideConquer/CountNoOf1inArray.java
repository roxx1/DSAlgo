package problem_solving.divideConquer;

public class CountNoOf1inArray {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int startPointOf1 = findStartOf1InArray(arr, 0, arr.length - 1);
        System.out.println(arr.length - startPointOf1);
    }

    private static int findStartOf1InArray(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if ((mid == 0 || arr[mid - 1] == 0) && arr[mid] == 1) {
            return mid;
        }
        if ((mid != arr.length) && (arr[mid + 1] == 1 && (arr[mid] == 0))) {
            return mid + 1;
        }
        if (arr[mid] == 0) {
            return findStartOf1InArray(arr, mid + 1, end);
        } else {
            return findStartOf1InArray(arr, start, mid);
        }
    }
}
