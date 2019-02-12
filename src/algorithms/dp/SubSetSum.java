package algorithms.dp;

public class SubSetSum {


    public static void main(String[] args) {
        int no[] = new int[]{6, 3, 2, 1};
        int sum = 12;

        boolean b = isSubsetSum(no, sum);
        System.out.println(b);

    }

    private static boolean isSubsetSum(int[] no, int sum) {

        boolean arr[][] = new boolean[no.length + 1][sum + 1];

        for (int i = 0; i <= sum; i++) {
            arr[0][i] = false;   // no elem all false
        }

        for (int i = 0; i <= no.length; i++) {
            arr[i][0] = true;   // no sum all true
        }

        for (int i = 1; i <= no.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j == no[i - 1]) {
                    arr[i][j] = true;
                } else if (j > no[i - 1]) {
                    arr[i][j] = arr[i - 1][j] || arr[i - 1][j - no[i - 1]];
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= no.length; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return arr[no.length][sum];
    }

}
