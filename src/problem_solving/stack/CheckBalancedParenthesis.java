package problem_solving.stack;

import java.util.Stack;

public class CheckBalancedParenthesis {

    public static void main(String[] args) {
        final String str = "[()]{}{[()()]}";
        checkBalancedParenthesis(str);
    }

    private static void checkBalancedParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        boolean b = false;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(str.charAt(i));
                    break;
                case '}':
                case ']':
                case ')':
                    b = !stack.isEmpty() && checkValidBracket(stack.pop(), str.charAt(i));
                    if (!b) {
                        stack.push(str.charAt(i));
                        break;
                    }
            }
        }

        if (stack.isEmpty())
            System.out.println("Valid Parenthesis");
        else
            System.out.println("Invalid Bracket Combination");
    }

    private static boolean checkValidBracket(Character top, Character c) {
        if (top == '{' && c == '}' || top == '(' && c == ')' || top == '[' && c == ']') {
            return true;
        }
        return false;
    }

}
