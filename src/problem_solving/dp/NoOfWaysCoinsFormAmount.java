package problem_solving.dp;

public class NoOfWaysCoinsFormAmount {
    public static void main(String[] args) {
        int coins[] = new int[]{1, 2, 3};
        int amount = 5;
        findNoOfWaysCoinsFormAmount(coins, amount);
    }

    private static void findNoOfWaysCoinsFormAmount(int[] coins, int amount) {
        final int length = coins.length;
        int noOfWays[][] = new int[length + 1][amount + 1];

        for (int i = 0; i <= amount; i++) {
            noOfWays[0][i] = 0;
        }
        for (int i = 0; i <= length; i++) {
            noOfWays[i][0] = 1;
        }

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    noOfWays[i][j] = noOfWays[i][j - coins[i - 1]] + noOfWays[i - 1][j];
                } else {
                    noOfWays[i][j] = noOfWays[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= length; i++) {
            System.out.println();
            for (int j = 0; j <= amount; j++) {
                System.out.print(noOfWays[i][j] + " ");
            }
        }

    }

}
