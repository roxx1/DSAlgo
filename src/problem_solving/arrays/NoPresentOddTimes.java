package problem_solving.arrays;

public class NoPresentOddTimes {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 2, 3, 1, 1};
        getOddOccurenceNo(arr);
    }

    private static void getOddOccurenceNo(int[] arr) {
        int no = arr[0];
        for (int i = 1; i < arr.length; i++) {
            no = no ^ arr[i];
        }

        System.out.println(no);
    }
}
