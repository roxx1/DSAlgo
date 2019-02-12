package problem_solving.arrays;

public class RotateMatrix90DegreeAnti {
    public static void main(String[] args) {

        int[][] data = new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                };

        rotateMatrixAnti(data);
    }

    private static void rotateMatrixAnti(int[][] data) {
        int x, y, len;

        for (int i = 0; i < data.length; i++) {
            len = data[i].length;
            x = 0;
            y = len - 1;

            while (x < y) {
                SwapUtils.swapNos(data[i], x, y);
                x++;
                y--;
            }
        }

        // take transpose 
       

    }

}
