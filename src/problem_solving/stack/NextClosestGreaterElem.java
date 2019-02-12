package problem_solving.stack;

import java.util.Stack;

public class NextClosestGreaterElem {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 1, 5, 25, 500, 60};
        printNextClosestGreaterElem(arr);
    }

    private static void printNextClosestGreaterElem(int[] arr) {
        final Stack<Integer> stack = new Stack<>();

        final int closestGreater[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[i] <= stack.peek()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    closestGreater[stack.pop()] = arr[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            closestGreater[stack.pop()] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < closestGreater.length; i++) {
            System.out.print(closestGreater[i] + " ");
        }
    }

}
