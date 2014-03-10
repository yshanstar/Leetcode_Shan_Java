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
    public ListNode rotateRight(ListNode head, int n) {
 		if(head == null || head.next == null){
 			return head;
 		}       

 		ListNode tail = head;
 		int count = 1;
 		while(tail.next != null){
 			count++;
 			tail = tail.next;
 		}
 		tail.next = head;

 		int shift = n % count;
 		int step = count - shift;

 		while(step > 0){
 			tail = tail.next;
 			step--;
 		}

 		ListNode newHead = tail.next;
 		tail.next = null;

 		return newHead;
    }
}