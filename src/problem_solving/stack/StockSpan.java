package problem_solving.stack;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 30, 10, 20, 25, 40, 26, 35, 45};
        //int[] arr = new int[]{1, 2, 3, 4, 5};
        calculateStockSpan(arr);
    }

    private static void calculateStockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] span = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    span[i] = i;
                } else {
                    span[i] = i - stack.peek() - 1;
                }
                stack.push(i);
        }

        for (int i1 = 0; i1 < span.length; i1++) {
            System.out.println(span[i1]);
        }
    }
}