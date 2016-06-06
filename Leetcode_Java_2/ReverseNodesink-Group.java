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
    public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null){
			return head;
		}

		if(k == 1){
			return head;
		}

		ListNode pre = new ListNode(-1);
		pre.next = head;
		head = pre;

		ListNode cur = pre.next;

		while(cur != null){
			int counter = k;
			while(cur != null && counter > 1){
				cur = cur.next;
				counter--;
			}

			if(cur != null){
				cur = pre.next;
				counter = k;
				while(counter > 1){
					ListNode tmp = cur.next;
					cur.next = tmp.next;
					tmp.next = pre.next;
					pre.next = tmp;
					counter--;	
				}
				pre = cur;
				cur = pre.next;
			}

		}

		return head.next;
    }
}