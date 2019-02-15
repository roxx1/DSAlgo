package problem_solving.string;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("gaadbbaaggaij");
        removeDuplicates(str);
    }

    private static void removeDuplicates(final StringBuilder str) {
        int i = 0, j = 0;
        int length = str.length();

        // g a a=>d d b b a a g g a a i j
        // i=0,j=0 i=1,j=1 i=2,j=2

        final Map<Character, Integer> map = new HashMap<>();

        while (j < length) {
            final char c = str.charAt(i);
            if (map.containsKey(c)) {
                j = i + 1;

                while (j < length) {
                    if (!map.containsKey(str.charAt(j))) {
                        str.setCharAt(i, str.charAt(j));
                        map.put(str.charAt(j), 1);
                        i++;
                        break;
                    } else {
                        j++;
                    }
                }

            } else {
                map.put(c, 1);
                str.setCharAt(i, str.charAt(j));
                i++;
                j++;
            }
        }

        System.out.println(str.substring(0, i));
    }
}