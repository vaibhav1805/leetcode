package graphs.trees;

import bst.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

//PROBLEM
/*
Given a binary tree with n nodes, your task is to check if it's possible to
partition the tree to two trees which have the equal sum of values after removing
exactly one edge on the original tree.

Input:
    5
   / \
  10 10
    /  \
   2   3

Output: True

https://leetcode.com/problems/equal-tree-partition/
 */

//SOLUTION
/*
Traverse tree and record sums of all subtrees in a set. At the end check set for total sum/2.
Odd sums are ruled out as they can't be divided into two.
*/

public class EqualTreePartition {
    public int recordSum(TreeNode node, Set<Integer> sums){
        if(node == null){
            return 0;
        }

        int l = recordSum(node.left, sums);
        int r = recordSum(node.right, sums);

        sums.add(l+r+node.val);
        return l+r+node.val;
    }

    public boolean checkEqualTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return false;
        }
        Set<Integer> sums = new HashSet<>();

        int sum = recordSum(root, sums);
        if(sum == 0 && sums.size()>1){
            return false;
        }
        if(sum%2 == 0){
            return sums.contains(sum/2);
        }
        return false;
    }
}
