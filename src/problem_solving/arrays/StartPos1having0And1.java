package problem_solving.arrays;

public class StartPos1having0And1 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 1};
        int pos = findStartingPosition1(arr, 0, arr.length - 1);
        System.out.println(pos);
    }

    private static int findStartingPosition1(int[] arr, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == 1 && (mid == l || arr[mid - 1] == 0)) {
                return mid;
            } else if (mid < r && arr[mid] == 0) {
                return findStartingPosition1(arr, mid + 1, r);
            } else {
                return findStartingPosition1(arr, l, mid - 1); // 0 3
            }
        } else {
            return -1;
        }
    }
}
