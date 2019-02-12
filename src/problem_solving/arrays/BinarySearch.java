package problem_solving.arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int x = applyBinarySearch(arr, 0, arr.length - 1, 6);
        System.out.println(x);
    }

    private static int applyBinarySearch(int[] arr, int l, int r, int k) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                return applyBinarySearch(arr, l, mid - 1, k);
            } else {
                return applyBinarySearch(arr, mid + 1, r, k);
            }
        } else
            return -1;
    }

}
