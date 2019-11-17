package problem_solving.bit_manipulation;

public class CheckPowerOf4 {

    public static void main(String[] args) {
        int n = 16;

        while (n % 4 == 0) {
            n = n >> 2;
        }

        if (n == 1) {
            System.out.println("No is power of 4");
        } else {
            System.out.println("No is not power of 4");
        }

    }

}
