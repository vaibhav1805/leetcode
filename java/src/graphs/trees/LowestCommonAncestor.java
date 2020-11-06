package graphs.trees;

//PROBLEM
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
*/

//SOLUTION
/*

*/

import bst.utils.TreeNode;

public class LowestCommonAncestor {
    public boolean isExists(TreeNode root, TreeNode p){
        if(root == null){
            return false;
        }

        if(root.val == p.val){
            return true;
        }

        return isExists(root.left, p) || isExists(root.right, p);
    }

    //O(n^2)
    public TreeNode lowestCommonAncestorA1(TreeNode root, TreeNode p, TreeNode q) {
        boolean pl = isExists(root.left, p);
        boolean qr = isExists(root.right, q);

        if(pl && qr){
            return root;
        }

        if(pl && ! qr){
            return (root.val == q.val) ? root :  lowestCommonAncestorA1(root.left, p, q);
        }

        if(!pl && qr){
            return (root.val == p.val) ? root :  lowestCommonAncestorA1(root.right, p, q);
        }

        if(!pl && !qr){
            return lowestCommonAncestorA1(root, q, p);
        }

        return null;
    }


    TreeNode res = null;

    public boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        int found = (root == p || root == q) ? 1:0;
        int l = (helper(root.left, p, q)) ? 1:0;
        int r = (helper(root.right, p, q)) ? 1:0;

        if(l+r+found >=  2){
            res = root;
        }
        return ((l+r+found) > 0);
    }

    //O(n)
    public TreeNode lowestCommonAncestorA2(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

}
