package problem_solving.tree.serialize;

import data_structures.tree.TreeNode;
import problem_solving.tree.BinTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SerializeBT {
    public static final String FILE_PATH = "/Users/nc3775/DSAlgo/src/problem_solving/tree/serialize/serialize.txt";

    public static void main(String[] args) throws IOException {
        final TreeNode root = BinTree.createTree();

          /*      1
             2          3
          4    5      6   7
        8   9      10      11
   */
        StringBuilder sb = new StringBuilder();
        serializeBinTree(root, sb);
        System.out.println(sb.toString());
        writeToFile(sb);
        return;
    }

    private static void writeToFile(StringBuilder sb) throws IOException {
        File f = new File(FILE_PATH);
        if (!f.exists()) {
            f.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(sb.toString());
        bw.flush();
    }

    private static void serializeBinTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("/");
            return;
        }
        sb.append(root.getData());
        serializeBinTree(root.getLeft(), sb);
        serializeBinTree(root.getRight(), sb);
    }
}
