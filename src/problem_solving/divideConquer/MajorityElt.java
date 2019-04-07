package problem_solving.divideConquer;

public class MajorityElt {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 0, 1, 1, 1, 1, 1, 5};
        findMajorityElt(arr);
    }

    private static void findMajorityElt(int[] arr) {
        int mid = arr.length / 2;
        int k = arr[mid];
        int start = findFirstOccurence(arr, 0, mid, k);
        int end = findLastOccurence(arr, mid, arr.length - 1, k);
        if (((end - start) >= mid) && start != -1 && end != -1) {
            System.out.println(arr[mid]);
        } else {
            System.out.println("No Majority Element");
        }
    }

    private static int findFirstOccurence(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k && (mid == 0 || arr[mid - 1] < k)) {
            return mid;
        }
        int x = findFirstOccurence(arr, start, mid - 1, k);
        if (x != -1) {
            return x;
        }
        return findFirstOccurence(arr, mid + 1, end, k);
    }

    private static int findLastOccurence(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k && (mid == arr.length - 1 || arr[mid + 1] > k)) {
            return mid;
        }
        int x = findLastOccurence(arr, start, mid - 1, k);
        if (x != -1) {
            return x;
        }
        return findLastOccurence(arr, mid + 1, end, k);
    }

}
