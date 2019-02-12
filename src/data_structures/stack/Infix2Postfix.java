package data_structures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Infix2Postfix {

    private Infix2Postfix() {
        throw new AssertionError();
    }

    private static final String input = "A+(B*C-(D/E^F)*G)*H";

    private static Stack<Character> stack = new Stack<>();
    private static final List<Character> expression = new ArrayList<>();

    public static void convertInfix2PostFix() {
        for (int i = 0; i < input.length(); i++) {
            final char c = input.charAt(i);
            final Integer precedence = fetchPrecedence(c);
            if (precedence.equals(0)) {
                stack.push(c);
            } else if (precedence.equals(1)) {
                while (isStackNotEmptyAndOpeningBracketNotPresent() && fetchPrecedence(stack.peek()) > precedence) {
                    expression.add(stack.pop());
                }
                stack.push(c);
            } else if (precedence.equals(2) || precedence.equals(3)) {
                while (isStackNotEmptyAndOpeningBracketNotPresent() && fetchPrecedence(stack.peek()) > precedence) {
                    expression.add(stack.pop());
                }
                stack.push(c);
            } else if (precedence.equals(4)) {
                while (isStackNotEmptyAndOpeningBracketNotPresent()) {
                    expression.add(stack.pop());
                }
                if (!stack.isEmpty() && fetchPrecedence(stack.peek()).equals(0)) {
                    stack.pop();
                }
            } else {
                expression.add(c);
            }
        }
        while (!stack.isEmpty()) {
            expression.add(stack.pop());
        }

    }

    public static boolean isStackNotEmptyAndOpeningBracketNotPresent() {
        return !stack.isEmpty() && !fetchPrecedence(stack.peek()).equals(0);
    }

    public static Integer fetchPrecedence(final char c) {
        switch (c) {
            case '{':
            case '(':
            case '[':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case '}':
            case ')':
            case ']':
                return 4;
            default:
                return -1;  // for Letters
        }
    }


    public static void main(String[] args) {
        convertInfix2PostFix();
        System.out.println(expression.toString());  // ABC*DEF^/G*-H*+
        System.out.println(stack.toString());
    }

}
