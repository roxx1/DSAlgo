package problem_solving.divideConquer;

public class CheckAiEqualsi {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 2, 3, 6, 8, 9, 11, 12, 23, 25, 27, 54};
        int index = findIndexAiEqualsi(arr, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int findIndexAiEqualsi(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == mid) {
            return mid;
        }
        if (arr[mid] < mid) {
            return findIndexAiEqualsi(arr, mid + 1, end);
        } else {
            return findIndexAiEqualsi(arr, start, mid - 1);
        }

    }
}
