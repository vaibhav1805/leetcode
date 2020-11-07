package graphs.trees;

import bst.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

//PROBLEM
/*
Given the root of a Binary Search Tree and a target number k,
return true if there exist two elements in the BST such that their sum is equal to the given target.

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
*/

//APPROACH
/*
For each node check if set contains its value, else store it's complement in a set.
 */
public class TwoSumIVBST {
    Set<Integer> comp = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        if(comp.contains(root.val)){
            return true;
        }
        comp.add(k-root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
