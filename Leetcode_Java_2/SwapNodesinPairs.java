/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }

        ListNode newHead = null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;

        while(cur != null && next != null){
        	ListNode tmp = next.next;

        	cur.next = tmp;
        	next.next = cur;

        	if(pre != null){
        		pre.next = next;
        	}
        	pre = cur;	
        	
        	
        	if(newHead == null){
        		newHead = next;
        	}
        	
        	cur = tmp;
        	next = (cur != null ) ? cur.next : null;
        	
        }

        return newHead;
    }
}