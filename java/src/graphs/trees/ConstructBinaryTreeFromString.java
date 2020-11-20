package graphs.trees;

import bst.utils.TreeNode;
import java.util.Stack;

/**
 * PROBLEM
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or
 * two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis
 * contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 *
 * SOLUTION
 *Split string with balanced parenthesis
 *          4
 *  2(3)(1)   6(5)
 *
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 */
public class ConstructBinaryTreeFromString {
    public TreeNode helper(String s){
        int rIdx = s.indexOf('(');
        TreeNode node = null;
        if(rIdx > 0){
            node = new TreeNode(Integer.parseInt(s.substring(0, rIdx)));
        }else{
            return new TreeNode(Integer.parseInt(s));
        }

        String l = "";
        String r = "";
        Stack<Integer> stack = new Stack<>();

        for(int i=rIdx; i<s.length(); ++i){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(!stack.isEmpty() && s.charAt(i) == ')'){
                int start = stack.pop();

                if(stack.isEmpty()){
                    if(l.isEmpty()){
                        l = s.substring(start +1, i);
                    }else{
                        r = s.substring(start +1, i);
                    }
                }
            }
        }

        if(!l.isEmpty()){
            node.left = helper(l);
        }

        if(!r.isEmpty()){
            node.right = helper(r);
        }

        return node;
    }

    public TreeNode str2tree(String s) {
        if(s.length() == 0){
            return null;
        }
        TreeNode root = helper(s);
        return root;
    }
}
