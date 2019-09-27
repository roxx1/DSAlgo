package problem_solving.divideConquer;

public class NUniqueBST {

    public static void main(String[] args) {
        int n = 3;
        int total = calculateUniqueBST(n);
        System.out.println(total);
    }

    private static int calculateUniqueBST(int n) {
        if (n == 0 || n == 1)
            return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (calculateUniqueBST(i - 1) * calculateUniqueBST(n - i));
        }
        return sum;
    }

}
