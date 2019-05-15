package problem_solving.dp;

public class NBitNosWithNo2ConsecutiveZeroes {

    public static void main(String[] args) {
        int n = 5;
        /*
        if n = 4   _ _ _ _
        case1 : if 0 _ _ _ (second bit can be 1 only) => problem size reduce by 2 f(n-2)
        case2: if 1 _ _ _ (second bit can be 0 or 1) => problem size reduces by 1 f(n-1)
         */
        int fib[] = new int[n + 1];
        fib[0] = 0;
        fib[1] = 2;
        fib[2] = 3;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2]; // f(n) = f(n-1) + f(n-2)
        }
        System.out.println(fib[n]);
    }
}
