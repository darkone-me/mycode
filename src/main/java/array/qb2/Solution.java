package array.qb2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //圈数
        for (int i = 0; i < n / 2; ++i) {
            //每次替换4个数 替换一圈 
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];

                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

                matrix[j][n - 1 - i] = tmp;
                System.out.println(i + "+" + j);
            }
        }
    }

    /*public static void main(String[] args) {
        int[][] nums = new int[9][9];
        nums[0] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[1] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[2] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[4] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[5] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[6] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[7] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        nums[8] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        new Solution().rotate(nums);
    }*/

    public static void main(String[] args) {

        Tree a = new Tree('A');
        Tree b = new Tree('B');
        Tree c = new Tree('C');
        Tree d = new Tree('D');
        Tree e = new Tree('E');
        Tree f = new Tree('F');
        Tree g = new Tree('G');

        a.trees.add(b);
        a.trees.add(c);
        a.trees.add(d);

        b.trees.add(e);

        c.trees.add(e);
        c.trees.add(f);

        f.trees.add(g);

        d.trees.add(g);

        char target = 'G';

        Queue<Tree> queue = new LinkedList<>();
        queue.offer(a);

        Tree result = null;
        boolean find = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree tree = queue.peek();
                queue.poll();
                if (tree != null) {
                    if (tree.character.equals(target)) {
                        result = tree;
                        find = true;
                        break;
                    }
                    for (Tree node : tree.trees) {
                        queue.offer(node);
                        if (node.parent == null) {
                            node.parent = tree;
                        }
                    }
                }
                
            }
            if (find) {
                break;
            }
        }

        while (result != null) {
            System.out.print(result.character + " -> ");
            result = result.parent;
        }

    }

    private static class Tree {

        private Character character;
        private List<Tree> trees;
        private Tree parent;

        public Tree(Character character) {
            this.character = character;
            this.trees = new ArrayList<>(2);
        }
    }

}
