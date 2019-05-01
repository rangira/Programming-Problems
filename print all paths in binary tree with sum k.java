/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode (int val) {
		this.val = val;
		left = null;
		right = null;
		parent = null;
	}
	
	public String toString() {
		return this.val + " ";
	}
}
 class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    

    
    public List<List<Integer>> binaryTreePathSum3(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, target, results);
        return results;
    }

    //     1
    //    / \
    //   2   3
    //  /
    // 4
    // and target = 6. Return :

    // [
    //   [2, 4],
    //   [2, 1, 3],
    //   [3, 1, 2],
    //   [4, 2]
    // ]        
    
    private static void helper(TreeNode root,
                        int target,
                        List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        /* Find the target with this root node as the root */
        List<Integer> path = new ArrayList<Integer>();
        findSum(root, null, target, path, results);

        helper(root.left, target, results);
        helper(root.right, target, results);
    }

    private static void findSum(TreeNode root,
                         TreeNode father,
                         int target,
                         List<Integer> path,
                         List<List<Integer>> results) {
        path.add(root.val);
        target -= root.val;

        if (target == 0) {
            /* Deep copy an ArrayList */
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            Collections.addAll(tmp, new Integer[path.size()]);
            Collections.copy(tmp, path);

            /* Add one of the paths to the results */
            results.add(tmp);
        }

        if (root.parent != null && root.parent != father) {
            findSum(root.parent, root, target, path, results);
        }

        if (root.left != null && root.left != father) {
            findSum(root.left, root, target, path, results);
        }

        if (root.right != null && root.right != father) {
            findSum(root.right, root, target, path, results);
        }

        /* DFS backtracking */
        path.remove(path.size() - 1);
    }
    
    public static void main(String[]args) {
        /*
         *     3
         *    / \
         *   4   2
         *  / \   \
         * 1   3   7
         * \   /  /
         *  8 6  9
         */
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3),
                 n4 = new TreeNode(3), n5 = new TreeNode(4), n6 = new TreeNode(6),
                 n7 = new TreeNode(7), n8 = new TreeNode(8), n9 = new TreeNode(9);
        n4.left = n5;
        n4.right = n2;
        n4.parent = null;
        
        n5.left = n1;
        n5.right = n3;
        n5.parent = n4;
        
        n1.right = n8;
        n1.parent = n5;
        
        n3.left = n6;
        
        n2.right = n7;
        n2.parent = n4;
        
        n7.left = n9;
        //TreeNode.printTree(n4);
        System.out.println();
        List<List<Integer>> results = new ArrayList();
        helper( n4, 9,  results);
        //printResult(result);
        //result = findSumPaths(n4, 9);
        printResult(results);
    }
    
    private static void printResult(List<List<Integer>> result) {
        for (List<Integer> path : result) {
            for (Integer n : path) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
