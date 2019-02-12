package problem_solving.stack;

import java.util.Stack;

public class StackGetMinInOrder1 {

    public static void main(String[] args) {

        final int arr[] = new int[]{10, 6, 12, 5, 13, 7, 2, 1};
        Integer min = Integer.MAX_VALUE;
        final Stack<Integer> stack = new Stack<>();
        final Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);

            if (arr[i] < min) {
                min = arr[i];
            }
            minStack.push(min);
        }

        getMinInOrder1Approach1(stack, minStack);
    }

    private static void getMinInOrder1Approach1(Stack<Integer> stack, Stack<Integer> minStack) {

        while (!stack.isEmpty()) {
            stack.pop();
            final Integer min = minStack.pop();
            System.out.print(min + "  ");
        }

    }


}
