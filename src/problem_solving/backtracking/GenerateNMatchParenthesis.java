package problem_solving.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateNMatchParenthesis {
    static List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        int n = 2;

        generateNMatchBrackets(n, n, "");
        for (String s : output) {
            System.out.println(s);
        }
    }

    private static void generateNMatchBrackets(int leftBracketsLeft, int rightBracketsLeft, String currString) {
        if (leftBracketsLeft == 0 && rightBracketsLeft == 0) {
            output.add(currString);
            return;
        }


        if (leftBracketsLeft > 0) {
            generateNMatchBrackets(leftBracketsLeft - 1, rightBracketsLeft, currString + "(");
        }

        if (leftBracketsLeft < rightBracketsLeft) {
            generateNMatchBrackets(leftBracketsLeft, rightBracketsLeft - 1, currString + ")");
        }

    }

}
