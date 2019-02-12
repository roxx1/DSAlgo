package problem_solving.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private static final Queue<Integer> q1 = new ArrayDeque<>();
    private static final Queue<Integer> q2 = new ArrayDeque<>();

    public static void push(Integer item) {
        if (q1.isEmpty()) {
            q1.offer(item);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else if (q2.isEmpty()) {
            q2.offer(item);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }
    }

    public static Integer pop() {
        Integer elem = null;
        if (q1.isEmpty()) {
            elem = q2.poll();
        } else {
            elem = q1.poll();
        }
        return elem;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            push(arr[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(pop());
        }

    }

}


