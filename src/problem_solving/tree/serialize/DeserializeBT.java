package problem_solving.tree.serialize;

import data_structures.tree.TreeNode;
import problem_solving.tree.util.TreeOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static problem_solving.tree.serialize.SerializeBT.FILE_PATH;

public class DeserializeBT {

    private static int len = 0;
    private static String line = null;

    public static void main(String[] args) throws IOException {
        File f = new File(FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(f));
        line = br.readLine();
        System.out.println(line);  //--->  1248//9//5//3610///7/11//
        final TreeNode root = createBinTreeAfterDeserialize();
              /*    1
             2          3
          4    5      6   7
        8   9      10      11
   */
        TreeOperations.printPreorder(root);

    }

    private static TreeNode createBinTreeAfterDeserialize() {
        if (len == line.length() || line.charAt(len) == '/') {
            return null;
        } else {
            TreeNode root = TreeOperations.createNewNode(Character.getNumericValue(line.charAt(len++)));
            root.setLeft(createBinTreeAfterDeserialize());
            root.setRight(createBinTreeAfterDeserialize());
            return root;
        }
    }
}
