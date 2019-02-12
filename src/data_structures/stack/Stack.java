package data_structures.stack;

public class Stack {

    private static Integer top = -1;

    private static final Integer MAX = 10;

    private static final Integer[] stack = new Integer[MAX];

    public static void push(final Integer data) {
        if (top == MAX - 1) {
            System.out.println("Overflow");
            return;
        }
        stack[++top] = data;
    }

    public static Integer pop() {
        if (top == -1) {
            System.out.println("Underflow Already Empty");
            return -1;
        }
        return stack[top--];
    }

    public static void printStack() {
        if (top == -1) return;
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        push(10);
        push(3);
        pop();
        push(5);
        pop();
        push(7);
        push(44);
        printStack();
    }
}
