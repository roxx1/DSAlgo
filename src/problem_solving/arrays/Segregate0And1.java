package problem_solving.arrays;

public class Segregate0And1 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0, 0, 1, 1, 0, 1, 0};
        segregateValues0And1(arr);
    }

    private static void segregateValues0And1(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[j] == 0) {
                if (arr[i] == 1) {
                    SwapUtils.swapNos(arr, i, j);
                }
                i++;
            } else {
                j--;
            }
        }

        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(arr[i1] + " ");
        }
    }
}
