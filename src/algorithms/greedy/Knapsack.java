package algorithms.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {

    private int weight;
    private double profit;

    public Knapsack() {
    }

    public Knapsack(int weight, double profit) {
        this.weight = weight;
        this.profit = profit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public static void main(String[] args) {

        int m = 15; // max capacity
        double profit = 0.0;

        Knapsack k1 = new Knapsack(2, 10);
        Knapsack k2 = new Knapsack(3, 5);
        Knapsack k3 = new Knapsack(5, 15);
        Knapsack k4 = new Knapsack(7, 7);
        Knapsack k5 = new Knapsack(1, 6);
        Knapsack k6 = new Knapsack(4, 18);
        Knapsack k7 = new Knapsack(1, 3);

        List<Knapsack> knapsacks = Arrays.asList(k1, k2, k3, k4, k5, k6, k7);

        Comparator<Knapsack> comparator = Comparator.comparing(ks -> (ks.getProfit() / ks.getWeight()));

        Collections.sort(knapsacks, comparator.reversed());

        Knapsack knapsack = null;
        for (int i = 0; i < knapsacks.size(); i++) {
            knapsack = knapsacks.get(i);
            if (knapsack.getWeight() <= m && m > 0) {
                m = m - knapsack.getWeight();
                profit += knapsack.getProfit();
            } else {
                break;
            }
        }

        if (m > 0) {
            profit += m * (knapsack.getProfit() / knapsack.getWeight());
        }

        System.out.println(profit);
    }

}
