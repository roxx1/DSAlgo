package problem_solving.arrays;

public final class SwapUtils {

    private SwapUtils() {
        throw new AssertionError();
    }

    public static void swapNos(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
