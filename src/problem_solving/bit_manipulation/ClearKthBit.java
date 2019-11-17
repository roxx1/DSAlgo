package problem_solving.bit_manipulation;

public class ClearKthBit {
    public static void main(String[] args) {
        int n = 11;
        int k = 2;

        n = n & (~(1 << k - 1));
        System.out.println(n);
    }
}
