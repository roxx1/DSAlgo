package problem_solving.divideConquer;

public class ElementIn2DMatrixSortedRowAndColumnWise {

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {1, 10, 25, 50},
                {5, 16, 28, 60},
                {7, 32, 32, 72},
                {9, 43, 52, 92}
        };
        int x = 9;
        findElt(arr, x);
    }

    private static void findElt(int[][] arr, int x) {
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println(i + " " + j);
                break;
            }
            if(arr[i][j]<x){
                i++;
            }else{
                j--;
            }
        }
    }

}
