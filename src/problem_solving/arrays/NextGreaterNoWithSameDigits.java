package problem_solving.arrays;

import java.util.Arrays;

public class NextGreaterNoWithSameDigits {

    public static void main(String[] args) {
        int[] no = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 4, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] no1 = new int[]{9, 8, 7, 6, 5, 4, 3};
        int[] no2 = new int[]{2, 1, 8, 7, 6, 5};
        findNextGreaterNoDigits(no2);
    }

    private static void findNextGreaterNoDigits(int[] no) {
        int j = 0, flag = 0;

        for (int i = no.length - 1; i > 0; i--) {
            if (no[i] > no[i - 1]) {
                j = i - 1;
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            int minGreater = Integer.MAX_VALUE;
            int pos = j;
            for (int i = j + 1; i < no.length; i++) {
                if (no[i] > no[j]) {
                    if (no[i] < minGreater) {
                        minGreater = no[i];
                        pos = i;
                    }
                }
            }

            SwapUtils.swapNos(no, j, pos);
            Arrays.sort(no, j + 1, no.length);

            for (int i = 0; i < no.length; i++) {
                System.out.print(no[i] + " ");
            }

        } else {
            System.out.println("Not Possible");
        }

    }
}
