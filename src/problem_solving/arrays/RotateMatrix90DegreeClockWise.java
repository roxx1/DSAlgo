package problem_solving.arrays;

public class RotateMatrix90DegreeClockWise {
    public static void main(String[] args) {

        int[][] data = new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                };

        rotate(data);
    }

    public static void rotate(int[][] matrix) {
        int i, j, k;
        int n = matrix.length;

        // transpose
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
            }
        }

        //printMatrix(matrix);

        // swap columns
        for (i = 0; i < n; i++) {
            j = 0;
            k = n - 1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                j++;
                k--;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}