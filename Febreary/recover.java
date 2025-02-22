package Febreary;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class recover {
     List<int[]> nodes = new ArrayList<>();
     int index = 0;

     public TreeNode recoverFromPreorder(String traversal) {
          int i = 0;
          while (i < traversal.length()) {
               int level = 0;
               while (i < traversal.length() && traversal.charAt(i) == '-') {
                    level++;
                    i++;
               }
               int idx = i;
               while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                    i++;
               }
               int value = Integer.parseInt(traversal.substring(idx, i));
               nodes.add(new int[] { level, value });
          }
          return buildTree(0);
     }

     private TreeNode buildTree(int depth) {
          if (index >= nodes.size() || nodes.get(index)[0] != depth) {
               return null;
          }
          int[] cur = nodes.get(index);
          TreeNode node = new TreeNode(cur[1]);
          index++;
          node.left = buildTree(depth + 1);
          node.right = buildTree(depth + 1);
          return node;
     }

     public static void main(String[] args) {

     }

}