package data_structures.recursion;

public class TOH {

    public static void movements(int n, char x, char y, char z) {
        if (n >= 1) {
            movements(n - 1, x, z, y);          // move n-1 disks from x to z  using y
            System.out.println(n + " disk no from top move from " + x + "  => " + y); // move x to y
            movements(n - 1, z, y, x);   // move n-1 disks from z to y   using x
        }
    }

    public static void main(String[] args) {
        movements(4, 'x', 'y', 'z');
    }
}
