package problem_solving.divideConquer;

public class PowerOfNum {

    public static void main(String[] args) {
        int x = 2;
        int n = 2;
        int result = calculatePowerOfNum(x, n);
        System.out.println(result);
    }

    private static int calculatePowerOfNum(int x, int n) {
        int temp;

        if (n == 0) {
            return 1;
        }

        temp = calculatePowerOfNum(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

}
