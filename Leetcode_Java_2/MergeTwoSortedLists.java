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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
        	return null;
        }

        if(l1==null){
        	return l2;
        }

        if(l2==null){
			return l1;
        }

        ListNode newHead = null;
        ListNode cur  = newHead;
		

		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				if(newHead == null){
					newHead = l1;
					cur = newHead;
				}else{
					cur.next = l1;
					cur = cur.next;
				}
				l1 = l1.next;
			}else{
				if(newHead == null){
					newHead = l2;
					cur = newHead;
				}else{
					cur.next = l2;
					cur = cur.next;
				}
				l2 = l2.next;
			}
		}

		if(l1 != null){
			cur.next = l1;
		}

		if(l2 != null){
			cur.next = l2;
		}

		return newHead;
    }
}