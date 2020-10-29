package graphs.trees;

import bst.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//PROBLEM
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

//SOLUTION
/*
Depth-First-Search
 */
public class PathSumII {
    public boolean dfs(TreeNode root, int sum, List<Integer> l){
        if(root == null){
            return false;
        }
        sum -= root.val;
        l.add(root.val);
        if(sum == 0 && root.left==null && root.right==null){
            res.add(l);
            return true;
        }

        List<Integer> l2 = new ArrayList<>(l);
        boolean left = dfs(root.left, sum, l);
        boolean right = dfs(root.right, sum, l2);

        return left || right;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());

        return res;
    }
}
