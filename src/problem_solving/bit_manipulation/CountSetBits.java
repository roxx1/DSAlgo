package problem_solving.bit_manipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 11;

        int i = n;
        int count = 0;

        while (i > 0) {
            if ((i & 1) == 1) {
                count++;
            }
            i = i >> 1;
        }
        System.out.println(count);
    }
}
