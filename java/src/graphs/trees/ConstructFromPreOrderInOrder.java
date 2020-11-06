package graphs.trees;

import bst.utils.TreeNode;

//PROBLEM
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

//SOLUTION
/*
First element of preorder will always be root.
Get root from preorder
partition inorder at index of root
make left partition of array as root.left
make right partition of array as root.right
*/

public class ConstructFromPreOrderInOrder {
    int rootIndex = 0;
    public TreeNode construct(int[] preorder, int[] inorder, int start, int end){
        if(start > end || rootIndex>=preorder.length){
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex]);
        int i = 0;
        while(inorder[i] != preorder[rootIndex]){
            i++;
        }

        rootIndex++;
        root.left = construct(preorder, inorder, start, i-1);
        root.right = construct(preorder, inorder, i+1, end);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, preorder.length-1);
    }
}
