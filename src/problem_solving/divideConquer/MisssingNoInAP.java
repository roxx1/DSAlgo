package problem_solving.divideConquer;

public class MisssingNoInAP {

    public static void main(String[] args) {
        int arr[] = new int[]{-2, 0, 2, 4, 8, 10, 12, 14, 16, 18, 20};
        int diff = 2; // calculate using AP Formula an = a+(n-1)d
        int missingNo = calculateMissingNo(arr, 0, arr.length - 1, diff);
        System.out.println(missingNo);
    }

    private static int calculateMissingNo(int[] arr, int start, int end, int diff) {
        if (start >= end) {
            return Integer.MAX_VALUE;
        }
        int mid = (start + end) / 2;
        if (mid > 0 && arr[mid] - arr[mid - 1] != diff) {
            return arr[mid - 1] + diff;
        }
        if (mid != arr.length - 1 && arr[mid + 1] - arr[mid] != diff) {
            return arr[mid] + diff;
        }
        if (arr[mid] == arr[0] + mid * diff) {
            return calculateMissingNo(arr, mid + 1, end, diff);
        } else {
            return calculateMissingNo(arr, start, mid - 1, diff);
        }
    }

}
