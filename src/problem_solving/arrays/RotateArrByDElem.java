package problem_solving.arrays;

public class RotateArrByDElem {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int d = 2;
        rotateArrayByD(arr, d);
    }

    private static void rotateArrayByD(int[] arr, int d) {
        int i = 0;
        int j = d - 1;
        while (i < j) {
            SwapUtils.swapNos(arr, i, j);
            i++;j--;
        }

        int length = arr.length;
        i = d;
        j = length - 1;

        while (i < j) {
            SwapUtils.swapNos(arr, i, j);
            i++;j--;
        }

        i = 0;
        j = length - 1;

        while (i < j) {
            SwapUtils.swapNos(arr, i, j);
            i++;j--;
        }

        for (int i1 = 0; i1 < arr.length; i1++) {
            System.out.print(arr[i1]+" => ");
        }
    }

}
