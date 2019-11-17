package problem_solving.bit_manipulation;

public class CheckNoPower2 {
    public static void main(String[] args) {
        int n = 32;
        if (n == 0) {
            System.out.println(false);
        } else {
            final int i = (n & (n - 1)); // 100000 & 011111
            System.out.println(i == 0 ? true : false);
        }
    }

}
