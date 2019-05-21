package problem_solving.dp;

public class CutRod {
    public static void main(String[] args) {
        int sizeRod[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20};
        findMaxPriceAfterSellingRodInPieces(sizeRod, price);
    }

    private static void findMaxPriceAfterSellingRodInPieces(int[] sizeRod, int[] price) {
        int profit[] = new int[sizeRod.length];
        for (int i = 1; i < profit.length; i++) {
            int maxPrice = price[i];
            for (int j = i - 1; j >= 0; j--) {
                if (sizeRod[i] >= j) {
                    final int profitJ = price[j] + price[sizeRod[i] - j];
                    if (profitJ > maxPrice) {
                        maxPrice = profitJ;
                    }
                }
            }
            profit[i] = maxPrice;
        }

        for (int i = 0; i < profit.length; i++) {
            System.out.println(profit[i]);
        }
    }
}
