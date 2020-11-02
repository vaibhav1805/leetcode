package graphs.trees;

import bst.utils.TreeNode;
import linkedlists.utils.ListNode;

//PROBLEM
/*
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
every node never differ by more than 1.

Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
 */

//APPROACH
/*
Using simple recursive approach at every level of recursion find the root which is
the middle of the list & split list into left and right. Repeat till leaves are reached.
 */
public class ConvertSortedListtoBST {
    public ListNode splitMiddle(ListNode head){
        ListNode slow = null;
        ListNode fast = head;

        while(fast !=null && fast.next != null){
            slow = (slow==null) ? head : slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null || head.next == null){
            return (head != null) ? new TreeNode(head.val) : null;
        }

        ListNode mid =splitMiddle(head);

        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }
}
