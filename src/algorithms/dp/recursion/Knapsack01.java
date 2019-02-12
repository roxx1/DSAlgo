package algorithms.dp.recursion;

public class Knapsack01 {

    public static void main(String[] args) {
        int p[] = new int[]{10, 12, 28};
        int[] weight = new int[]{1, 2, 4};
        int capacity = 6;

        int maxProfit = calculateMaxProfit(p, weight, capacity, weight.length);
        System.out.println(maxProfit);
    }

    private static int calculateMaxProfit(int[] p, int[] weight, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        } else if (capacity >= weight[n - 1]) {
            int a = p[n - 1] + calculateMaxProfit(p, weight, capacity - weight[n - 1], n - 1);
            int b = calculateMaxProfit(p, weight, capacity, n - 1);
            System.out.println("a => " + a + "  b => " + b);
            return Math.max(a, b);
        } else {
            return calculateMaxProfit(p, weight, capacity, n - 1);
        }
    }

}
