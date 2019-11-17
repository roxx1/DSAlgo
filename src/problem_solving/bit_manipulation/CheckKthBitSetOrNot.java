package problem_solving.bit_manipulation;

public class CheckKthBitSetOrNot {
    public static void main(String[] args) {
        int n = 11;

        int k = 2;

        int x = n & (1 << k - 1);

        System.out.println(x > 0);

    }
}
