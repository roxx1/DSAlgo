package problem_solving.bit_manipulation;

public class ToggleKthBit {
    public static void main(String[] args) {
        int n = 11;
        int k = 3;

        n = n ^ (1 << k - 1); // exclusive or    same bits 0 else 1
        System.out.println(n);
    }
}
