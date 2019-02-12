package problem_solving.arrays;

public class MajorityElem {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 3, 3, 3, 3, 7};
        findMajorityElem(arr);
    }

    private static void findMajorityElem(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i + arr.length / 2] == arr[i]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

}