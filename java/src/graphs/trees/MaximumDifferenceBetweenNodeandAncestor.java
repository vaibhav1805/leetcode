package graphs.trees;

import bst.utils.TreeNode;

/**
 * PROBLEM
 *
 * Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
 *
 * A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.
 *
 *
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 *
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */

/**
 * SOLUTION
 *
 * In a preorder traversal record min, max and diff. Return maximum diff always.
 */
public class MaximumDifferenceBetweenNodeandAncestor {
    public int helper(TreeNode root, int min, int max, int diff){
        if(root == null){
            return diff;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        diff = max-min;

        int l = helper(root.left, min, max, diff);
        int r = helper(root.right, min, max, diff);

        return Math.max(l, r);
    }
    public int maxAncestorDiff(TreeNode root) {
        int res = helper(root, root.val, root.val, 0);
        return res;
    }
}
