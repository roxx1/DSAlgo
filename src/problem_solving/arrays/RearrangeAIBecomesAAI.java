package problem_solving.arrays;

public class RearrangeAIBecomesAAI {
    public static void main(String[] args) {
        int a[] = new int[]{3, 1, 0, 2, 4};
        rearrangeArray(a);
    }

    private static void rearrangeArray(int[] a) {

        int n = a.length;

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] + ((a[a[i]] % n) * n);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] /= n;
        }

        for (int l : a) {
            System.out.print(l + " ");
        }

    }

}
