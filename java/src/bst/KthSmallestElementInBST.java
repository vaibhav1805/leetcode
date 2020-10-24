package bst;

import bst.utils.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

//PROBLEM
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

//APPROACH
/*
Inorder traversal in a BST gives sorted sequence in ascending order. Perform a DFS while decrementing k, till k=0.
 */
public class KthSmallestElementInBST {
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;

        while(tmp !=null){
            s.push(tmp);
            tmp = tmp.left;
        }

        while(!s.isEmpty()){
            TreeNode node = s.pop();
            k--;
            if(k == 0){
                return node.val;
            }

            if(node.right != null){
                s.push(node.right);
                TreeNode rl = node.right.left;

                while(rl!=null){
                    s.push(rl);
                    rl = rl.left;
                }
            }
        }
        return -1;
    }
}
