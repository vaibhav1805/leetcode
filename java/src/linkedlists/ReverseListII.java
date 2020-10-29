package linkedlists;


//PROBLEM
/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

https://leetcode.com/problems/reverse-linked-list-ii/
 */






//APPROACH
/*
m=1, n=4
1->2->3->4->5->NULL
mp h  n

m=1, n=3
1<->2 3->4->5->NULL
   mp  h  n

m=1, n=2
1<->2<-3 4->5->NULL
       mp h  n

m=1, n=1
1<->2<-3<-4 5->NULL
p           mp  h

m=1, n=0
1->2<-3->4 5->NULL
   --------->
 4->3->2->5
p         mp h  n
*/

import linkedlists.utils.ListNode;

public class ReverseListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode headRef = head;
        ListNode prev = null;

        if(m == n){
            return head;
        }
        while(m != 1){
            prev = (prev == null) ? head : prev.next;
            head = head.next;
            m--;
            n--;
        }

        ListNode mPrev = prev;
        ListNode next = head.next;
        while(n >= 1){
            head.next = mPrev;
            mPrev = head;
            head = next;
            next = (head != null) ? head.next : null;
            n--;
        }

        if(prev != null){
            prev.next.next = head;
            prev.next = mPrev;
        }else{
            headRef.next = head;
            headRef = mPrev;
        }

        return headRef;
    }
}
