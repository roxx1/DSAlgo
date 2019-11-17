package problem_solving.bit_manipulation;

public class NextHigherNoPower2 {
    public static void main(String[] args) {
        int n = 9; //  00001001

        int count = 0;
        while (n != 0) {
            count++;
            n = n >> 1;
        }

        int no = 1 << count;

        System.out.println(no);
    }
}
