package data_structures.queue;

import java.util.Stack;

public final class QUsing2Stacks {

    private QUsing2Stacks() {
        throw new AssertionError();
    }

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    static {
        for (int i = 1; i <= 5; i++) {
            stack1.push(i);
        }
    }

    public static void enqueue(final Integer data) {
        stack1.push(data);
    }

    public static Integer dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            } else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());

        // If given only 1 data_structures.stack with push pop and reverse method
        // then for dequeue we can do reverse() pop() reverse()
    }
}
