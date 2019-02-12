package problem_solving.stack;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeOverlappingIntervals {

    private static final Stack<Pair> STACK = new Stack<>();

    public static void main(String[] args) {

        final Pair<Integer, Integer> p1 = new Pair<>(6, 8);
        final Pair<Integer, Integer> p2 = new Pair<>(2, 5);
        final Pair<Integer, Integer> p3 = new Pair<>(1, 3);
        final Pair<Integer, Integer> p4 = new Pair<>(13, 20);
        final Pair<Integer, Integer> p5 = new Pair<>(9, 14);
        final Pair<Integer, Integer> p6 = new Pair<>(100, 120);

        final List<Pair<Integer, Integer>> pairs = Arrays.asList(p1, p2, p3, p4, p5, p6);

        pairs.sort(Comparator.comparing(x -> x.getKey()));

       /* for (Pair<Integer, Integer> pair : pairs) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }*/

        for (int i = 0; i < pairs.size(); i++) {
            final Pair<Integer, Integer> pair = pairs.get(i);

            if (STACK.isEmpty()) {
                STACK.push(pair);
            } else {
                final Pair<Integer, Integer> top = STACK.peek();
                if (pair.getKey() <= top.getValue()) {
                    if (top.getValue() < pair.getValue()) {
                        final Pair<Integer, Integer> pop = STACK.pop();
                        STACK.push(new Pair<Integer, Integer>(top.getKey(), pair.getValue()));
                    }
                } else {
                    STACK.push(pair);
                }
            }

        }

        STACK.forEach(pair -> System.out.println(pair.getKey() + "  " + pair.getValue()));

    }

}
