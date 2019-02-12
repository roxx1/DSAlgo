package data_structures.queue;

public final class QueueOperations {

    private QueueOperations() {
        throw new AssertionError();
    }

    private static final Integer MAX = 5;
    private static final Integer queue_circular[] = new Integer[MAX];
    private static Integer front = 0, rear = 0;

    public static void enqueue(final Integer data) {
        final Integer temp = (rear + 1) % MAX;

        // check if data_structures.queue is not full
        if (temp.equals(front)) {
            System.out.println("Queue is Already Full Overflow !!!, Not able to enqueue " + data);
        } else {
            queue_circular[temp] = data;
            rear = temp;
        }
    }

    public static Integer deque() {
        // check data_structures.queue is empty before deleting
        if (isQueueEmpty()) {
            System.out.println("Queue is empty Underflow !!!");
            return -1;
        } else {
            front = (front + 1) % MAX;
            return queue_circular[front];
        }
    }

    public static void printQueue() {
        if (isQueueEmpty()) return;
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(queue_circular[i]);
        }
    }

    public static boolean isQueueEmpty() {
        return front.equals(rear);
    }

    public static void main(String[] args) {
        enqueue(12);
        enqueue(23);
        enqueue(15);
        enqueue(15);
        enqueue(15);
        deque();
        deque();
        deque();
        deque();
        printQueue();
    }

}
